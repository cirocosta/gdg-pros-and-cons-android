package br.com.aeho.gdgprosandcons.Sync;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Bundle;

/**
 * Implementation of a Stub Authenticator to make it possible the use of the
 * SyncAdapter. 
 * 
 */
public class Authenticator extends AbstractAccountAuthenticator {

	public Authenticator(Context context) {
		super(context);
	}

	/**
	 * Don't add aditional accounts
	 * 
	 * @return null
	 */
	@Override
	public Bundle addAccount(AccountAuthenticatorResponse response,
			String accountType, String authTokenType,
			String[] requiredFeatures, Bundle options)
			throws NetworkErrorException {
		return null;
	}

	@Override
	public Bundle confirmCredentials(AccountAuthenticatorResponse response,
			Account account, Bundle options) throws NetworkErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not supported for a stub authenticator
	 * 
	 * @throws UnsupportedOperation
	 */
	@Override
	public Bundle editProperties(AccountAuthenticatorResponse response,
			String accountType) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Not supported for a stub authenticator
	 * 
	 * @throws UnsupportedOperation
	 */
	@Override
	public Bundle getAuthToken(AccountAuthenticatorResponse response,
			Account account, String authTokenType, Bundle options)
			throws NetworkErrorException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * Not supported for a stub authenticator
	 * 
	 * @throws UnsupportedOperation
	 */
	@Override
	public String getAuthTokenLabel(String authTokenType) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * Not supported for a stub authenticator
	 * 
	 * @throws UnsupportedOperation
	 */
	@Override
	public Bundle hasFeatures(AccountAuthenticatorResponse response,
			Account account, String[] features) throws NetworkErrorException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * Not supported for a stub authenticator
	 * 
	 * @throws UnsupportedOperation
	 */
	@Override
	public Bundle updateCredentials(AccountAuthenticatorResponse response,
			Account account, String authTokenType, Bundle options)
			throws NetworkErrorException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
