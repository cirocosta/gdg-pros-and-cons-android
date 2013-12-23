package br.com.aeho.gdgprosandcons.test;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import br.com.aeho.gdgprosandcons.LoginActivity;
import br.com.aeho.gdgprosandcons.MainActivity;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

public class LoginActivityTest extends
		ActivityInstrumentationTestCase2<LoginActivity> {

	private LoginActivity mActivity;
	private ActivityMonitor mActivityMonitor;

	@SuppressWarnings("deprecation")
	public LoginActivityTest() {
		super("br.com.aeho.gdgprosandcons", LoginActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();
	}

	public void testSkipLogin() {
		assertNotNull("Cannot start since target actv is null", mActivity);
		mActivityMonitor = getInstrumentation().addMonitor(
				MainActivity.class.getName(), null, false);
		MainActivity mMainActivity = null;
		Espresso.onView(
				ViewMatchers
						.withId(br.com.aeho.gdgprosandcons.R.id.login_activity_tvSkip))
				.perform(ViewActions.click());
		mMainActivity = (MainActivity) mActivityMonitor
				.waitForActivityWithTimeout(5000);
		assertNotNull("MainActivity is null but shouldnt", mMainActivity);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		if (mActivity != null) {
			mActivity.finish();
			mActivity = null;
		} else {
			getInstrumentation().removeMonitor(mActivityMonitor);
			mActivityMonitor = null;
		}
	}
}
