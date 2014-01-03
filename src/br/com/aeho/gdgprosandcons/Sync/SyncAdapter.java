package br.com.aeho.gdgprosandcons.Sync;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;

/**
 * Will handle the sync process between server and app using the SyncAdapter
 * framework
 */
public class SyncAdapter extends AbstractThreadedSyncAdapter {

	ContentResolver mContentResolver;

	public SyncAdapter(Context context, boolean autoInitialize) {
		super(context, autoInitialize);
		mContentResolver = context.getContentResolver();
	}

	@SuppressLint("NewApi")
	public SyncAdapter(Context context, boolean autoInitialize,
			boolean allowParallelSyncs) {
		super(context, autoInitialize, allowParallelSyncs);
		mContentResolver = context.getContentResolver();
	}

	@Override
	public void onPerformSync(Account account, Bundle extras, String authority,
			ContentProviderClient provider, SyncResult syncResult) {
		/*
		 * Implementation of sync. Will be performed in the background.
		 * 
		 * Connecting to Server; Downloading and Uploading data; Handling data
		 * conflicts or determining how current data is; Clean up
		 */
	}

}
