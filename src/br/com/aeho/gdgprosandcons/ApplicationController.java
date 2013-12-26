package br.com.aeho.gdgprosandcons;

import android.app.Application;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.ActionMode;

public class ApplicationController extends Application {

	private static ActionMode sActionMode;

	@Override
	public void onCreate() {
		super.onCreate();
	}

	public void startActionMode(ActionBarActivity activity,
			ActionMode.Callback callback) {
		sActionMode = activity.startSupportActionMode(callback);
	}

	public ActionMode getActionMode() {
		return sActionMode;
	}
}
