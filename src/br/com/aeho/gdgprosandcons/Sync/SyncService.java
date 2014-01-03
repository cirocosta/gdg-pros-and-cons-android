package br.com.aeho.gdgprosandcons.Sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Service that will return the IBinder to the SyncAdapter class. This will
 * allow it to call the method to perform the sync.
 */
public class SyncService extends Service {

	/**
	 * Singleton for the SyncAdapter instance
	 */
	private static SyncAdapter sSyncAdapter = null;
	/**
	 * Object to lock (thread-safe)
	 */
	private static final Object sSyncAdapterLock = new Object();

	@Override
	public void onCreate() {
		synchronized (sSyncAdapterLock) {
			if (sSyncAdapter == null) {
				sSyncAdapter = new SyncAdapter(getApplicationContext(), true);
			}
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return sSyncAdapter.getSyncAdapterBinder();
	}

}
