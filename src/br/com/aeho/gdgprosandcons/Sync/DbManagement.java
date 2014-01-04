package br.com.aeho.gdgprosandcons.Sync;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbManagement {
	private Context mContext;
	private SQLiteDatabase mDatabase;

	public DbManagement(Context context) {
		this.mContext = context;
	}

	public SQLiteDatabase open() {
		mDatabase = new DbHelper(mContext, DbHelper.DATABASE_NAME, null,
				DbHelper.DATABASE_VERSION).getWritableDatabase();
		return mDatabase;
	}

	public void close() {
		mDatabase.close();
	}
}
