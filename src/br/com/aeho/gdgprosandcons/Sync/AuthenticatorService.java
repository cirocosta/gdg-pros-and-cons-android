package br.com.aeho.gdgprosandcons.Sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Bound Service in order for the SyncAdapter framework to access the
 * authenticator. Provides an Android Binder object to allow the framework to
 * call the authenticator and pass data between them.
 * 
 * It instantiates the authenticator when started.
 */
public class AuthenticatorService extends Service {

	private Authenticator mAuthenticator;
	
	@Override
	public void onCreate() {
		mAuthenticator = new Authenticator(this);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return mAuthenticator.getIBinder();
	}

}
