package br.com.aeho.gdgprosandcons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends ActionBarActivity implements
		View.OnClickListener {

	private TextView tvSkip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		initialize_ui();

	}

	private void initialize_ui() {
		tvSkip = (TextView) findViewById(R.id.login_activity_tvSkip);
		tvSkip.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_activity_tvSkip:
			startActivity(new Intent(LoginActivity.this, MainActivity.class));
			break;
		}
	}
}
