package br.com.aeho.gdgprosandcons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class NewPostItActv extends ActionBarActivity implements
		View.OnClickListener {

	View mCustomActionBarView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		prepareActionBar();
		setContentView(R.layout.new_postit_actv);
		mCustomActionBarView.findViewById(R.id.actionbar_cancel)
				.setOnClickListener(this);
		mCustomActionBarView.findViewById(R.id.actionbar_done)
				.setOnClickListener(this);
	}

	private Bundle collectInputData() {
		final Bundle args = new Bundle();
		findViewById(R.id.new_postit_actv_cbAnonimo);
		args.putString("conteudo",
				((EditText) findViewById(R.id.new_postit_actv_etConteudo))
						.getText().toString());
		args.putString("titulo",
				((EditText) findViewById(R.id.new_postit_actv_etTitulo))
						.getText().toString());
		findViewById(R.id.new_postit_actv_tbMood);
		return args;
	}

	private void prepareActionBar() {
		final LayoutInflater inflater = (LayoutInflater) getSupportActionBar()
				.getThemedContext().getSystemService(LAYOUT_INFLATER_SERVICE);
		mCustomActionBarView = inflater.inflate(R.layout.ab_custom_donecancel,
				null);

		mCustomActionBarView.findViewById(R.id.actionbar_done)
				.setOnClickListener(this);
		mCustomActionBarView.findViewById(R.id.actionbar_cancel)
				.setOnClickListener(this);

		final ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM,
				ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME
						| ActionBar.DISPLAY_SHOW_TITLE);
		actionBar.setCustomView(mCustomActionBarView,
				new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.actionbar_cancel:
			setResult(RESULT_CANCELED, null);
			break;
		case R.id.actionbar_done:
			final Bundle args = collectInputData();
			Intent result = new Intent();
			result.putExtras(args);
			setResult(RESULT_OK, result);
			break;
		}
		finish();
	}
}
