package br.com.aeho.gdgprosandcons;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.plus.PlusClient;
import com.google.android.gms.plus.PlusClient.OnAccessRevokedListener;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class LoginActivity extends ActionBarActivity implements
		ConnectionCallbacks, OnConnectionFailedListener, OnClickListener,
		OnAccessRevokedListener {

	public static final int REQUEST_CODE_RESOLVE_ERR = 9000;
	private PlusClient mPlusClient;
	private ConnectionResult mConnectionResult;
	private ProgressDialog mConnectionProgressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);

		mPlusClient = new PlusClient.Builder(this, this, this)
				.setActions("http://schemas.google.com/AddActivity",
						"http://schemas.google.com/BuyActivity")
				.setScopes(Scopes.PLUS_LOGIN).build();

		findViewById(R.id.login_activity_tvSkip).setOnClickListener(this);
		findViewById(R.id.login_activity_bLogin).setOnClickListener(this);
		findViewById(R.id.login_activity_bLogout).setOnClickListener(this);

		mConnectionProgressDialog = new ProgressDialog(this);
		mConnectionProgressDialog.setMessage(getResources().getString(
				R.string.loging_in));
	}

	@Override
	protected void onStop() {
		super.onStop();
		mPlusClient.disconnect();
	}

	@Override
	protected void onStart() {
		super.onStart();
		mPlusClient.connect();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_activity_tvSkip:
			startActivity(new Intent(LoginActivity.this, MainActivity.class));
			break;
		case R.id.login_activity_bLogin:
			if (!mPlusClient.isConnected()) {
				if (mConnectionResult == null) {
					mConnectionProgressDialog.show();
				} else {
					try {
						mConnectionResult.startResolutionForResult(this,
								REQUEST_CODE_RESOLVE_ERR);
					} catch (SendIntentException e) {
						mConnectionResult = null;
						mPlusClient.connect();
					}
				}
			}
			break;
		case R.id.login_activity_bLogout:
			if (mPlusClient.isConnected()) {
				mPlusClient.clearDefaultAccount();
				mPlusClient.disconnect();
				mPlusClient.connect();
			}
			break;
		case R.id.login_activity_bRevoke:
			mPlusClient.clearDefaultAccount();

			mPlusClient
					.revokeAccessAndDisconnect(new OnAccessRevokedListener() {
						@Override
						public void onAccessRevoked(ConnectionResult status) {
						}
					});
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE_RESOLVE_ERR && resultCode == RESULT_OK) {
			mConnectionResult = null;
			mPlusClient.connect();
		}
	}

	@Override
	public void onConnected(Bundle connectionHint) {
		mConnectionProgressDialog.dismiss();
		Crouton.makeText(
				this,
				getResources().getString(R.string.login_ok) + "; "
						+ mPlusClient.getAccountName(), Style.CONFIRM).show();
	}

	@Override
	public void onAccessRevoked(ConnectionResult result) {

	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		if (mConnectionProgressDialog.isShowing()) {
			if (result.hasResolution()) {
				try {
					result.startResolutionForResult(this,
							REQUEST_CODE_RESOLVE_ERR);
				} catch (SendIntentException e) {
					mPlusClient.connect();
				}
			}
		}
		mConnectionResult = result;
	}

	@Override
	public void onDisconnected() {
		Crouton.makeText(this, "Disconnected", Style.ALERT).show();
	}
}
