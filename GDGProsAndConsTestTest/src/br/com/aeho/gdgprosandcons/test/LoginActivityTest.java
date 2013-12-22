package br.com.aeho.gdgprosandcons.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import br.com.aeho.gdgprosandcons.LoginActivity;

import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;

public class LoginActivityTest extends
		ActivityInstrumentationTestCase2<LoginActivity> {

	private LoginActivity mActivity;
	private TextView tvLogin;

	@SuppressWarnings("deprecation")
	public LoginActivityTest() {
		super("br.com.aeho.gdgprosandcons", LoginActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getActivity();
	}

	public void testSimpleClick() {
		onView(withId(br.com.aeho.gdgprosandcons.R.id.login_activity_tvSkip))
				.perform(ViewActions.click());
	}
}
