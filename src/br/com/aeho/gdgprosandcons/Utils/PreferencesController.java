package br.com.aeho.gdgprosandcons.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferencesController {

	public SharedPreferences prefs;
	public Editor editor;
	private Context mContext;
	public static final int PRIVATE_MODE = 0;
	public static final String PREFS_NAME = "gdgprosandcons_prefs";

	public PreferencesController(Context context) {
		this.mContext = context;
		prefs = mContext.getSharedPreferences(PREFS_NAME, PRIVATE_MODE);
	}

	public SharedPreferences getSharedPreferences() {
		return prefs;
	}

}
