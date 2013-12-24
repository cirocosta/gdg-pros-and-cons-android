package br.com.aeho.gdgprosandcons.test;

import android.app.Instrumentation.ActivityMonitor;
import android.support.v7.app.ActionBar;
import android.test.ActivityInstrumentationTestCase2;
import br.com.aeho.gdgprosandcons.VoteActv;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

public class VoteActvTest extends ActivityInstrumentationTestCase2<VoteActv> {

	private VoteActv mActivity;
	private ActivityMonitor mActivityMonitor;

	@SuppressWarnings("deprecation")
	public VoteActvTest(Class<VoteActv> activityClass) {
		super("br.com.aeho.gdgprosandcons", VoteActv.class);
	}

	public VoteActvTest() {
		super(VoteActv.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();
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

	public void testTabChangesFragment() {
	}

}
