package br.com.aeho.gdgprosandcons.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import br.com.aeho.gdgprosandcons.MainActivity;
import br.com.aeho.gdgprosandcons.R;
import br.com.aeho.gdgprosandcons.VoteActv;

import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity mActivity;
	private ActivityMonitor mActivityMonitor;

	@SuppressWarnings("deprecation")
	public MainActivityTest(Class<MainActivityTest> activityClass) {
		super("br.com.aeho.gdgprosandcons", MainActivity.class);
	}

	public MainActivityTest() {
		super(MainActivity.class);
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

	/**
	 * Verifica se esta abrindo e fechando corretamente
	 */
	public void testNavDrawerOpenClose() {
		onView(withId(android.R.id.home)).perform(click());
		onView(withId(R.id.main_activity_left_drawer)).check(
				matches(ViewMatchers.isDisplayed()));
		onView(withId(android.R.id.home)).perform(click());
		onView(withId(R.id.main_activity_left_drawer)).check(
				matches(not(ViewMatchers.isDisplayed())));
	}

	/**
	 * Se o menu desaparece quando abre e fecha
	 */
	// public void testNavDrawerMenuAppearing() {
	//
	// }

	// public void testNavDrawerItemClick() {
	//
	// }

	/**
	 * 
	 */
	public void testLista() {
		mActivityMonitor = getInstrumentation().addMonitor(
				VoteActv.class.getName(), null, false);
		assertNotNull("Cannot start test since target activity is null",
				mActivity);
		VoteActv mVoteActv = null;

		onView(ViewMatchers.withText("teste")).perform(ViewActions.click());
		mVoteActv = (VoteActv) mActivityMonitor
				.waitForActivityWithTimeout(5000);
		assertNotNull("VoteActv should not be NULL", mVoteActv);
	}

}
