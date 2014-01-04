package br.com.aeho.gdgprosandcons.Sync;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "gdgdb.db";
	public static final int DATABASE_VERSION = 1;
	
	public static final String TABLE_POSTIT = "PostIt";
	private static final String DATABASE_CREATE_TABLE_POSTIT = "CREATE TABLE " + TABLE_POSTIT + "(" +
					"_id INTEGER PRIMARY KEY, " +
					"bom INTEGER, " +
					"comentario TEXT, " +
					"titulo TEXT, " +
					"data INTEGER " +
				");";

	public DbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE_TABLE_POSTIT);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
