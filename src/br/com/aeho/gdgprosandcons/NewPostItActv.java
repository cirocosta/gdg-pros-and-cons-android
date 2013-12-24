package br.com.aeho.gdgprosandcons;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
			break;
		case R.id.actionbar_done:
			break;
		}
	}
}
