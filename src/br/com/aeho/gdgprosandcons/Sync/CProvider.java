package br.com.aeho.gdgprosandcons.Sync;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;
import br.com.aeho.gdgprosandcons.Utils.Constants;

/**
 * Implementation of the ContentProvider
 */
public class CProvider extends ContentProvider {

	private static final String AUTHORITY = Constants.AUTHORITY;
	
	//URI
	public static final Uri CONTENT_URI_POSTIT = Uri.parse(
			"content://" + AUTHORITY + "/postit");
	//MATCH_URI
	public static final int POSTIT = 0;
	
	//MATCHER
	private static final UriMatcher uriMatcher;
	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(AUTHORITY, "postit", POSTIT);
	}

	@Override
	public boolean onCreate() {
		return true;
	}
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		return new String();
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase db = new DbManagement(getContext()).open();
		int match = uriMatcher.match(uri);
		Uri contentUri = null;
		String nullColumnHack = null;
		long id = 0;
		
		switch(match){
		case POSTIT:
			contentUri = CONTENT_URI_POSTIT;
			id = db.insert(DbHelper.TABLE_POSTIT, nullColumnHack, values);
			break;
		default:
			throw new IllegalArgumentException("Unknown URI: " + uri);
		}
		
		if(id > -1){
			Uri insertedId = ContentUris.withAppendedId(contentUri, id);
			getContext().getContentResolver().notifyChange(contentUri, null);
			return insertedId;
		}
		return null;
	}
	

	@Override
	public int bulkInsert(Uri uri, ContentValues[] values) {
		int numInserted = 0;
		int match = uriMatcher.match(uri);
		String table = null;
		
		switch(match){
		case POSTIT:
			table = DbHelper.TABLE_POSTIT;
			break;
		default:
			throw new IllegalArgumentException("Unknown URI: " + uri);
		}

		SQLiteDatabase db = new DbManagement(getContext()).open();
		db.beginTransaction();
		try {
			for (ContentValues cv : values) {
				long newID = db.insertOrThrow(table, null, cv);
				if (newID <= 0) {
					throw new SQLException("Failed to insert row into " + uri);
				}
			}
			db.setTransactionSuccessful();
			getContext().getContentResolver().notifyChange(uri, null);
			numInserted = values.length;
		} finally {
			db.endTransaction();
		}
		return numInserted;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		int match = uriMatcher.match(uri);
		Cursor cursor = null;
		String groupBy = null;
		String having = null;
		
		switch(match){
		case POSTIT:
			queryBuilder.setTables(DbHelper.TABLE_POSTIT);
			break;
		default:
			throw new IllegalArgumentException("Unknown URI: " + uri);
		}
		
		SQLiteDatabase db = new DbManagement(getContext()).open();
		cursor = queryBuilder.query(db, projection, selection, 
				selectionArgs, groupBy, having, sortOrder);
		cursor.setNotificationUri(getContext().getContentResolver(), uri);
		return cursor;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		return 0;
	}

}
