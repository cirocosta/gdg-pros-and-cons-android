package br.com.aeho.gdgprosandcons.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Suppress;
import br.com.aeho.gdgprosandcons.MainActivity;
import br.com.aeho.gdgprosandcons.R;
import br.com.aeho.gdgprosandcons.VoteActv;

import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions;
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
	 * Verifica se esta abrindo e fechando corretamente ps.: ha um problema de
	 * sincronizacao do espresso com o utils
	 */
	@Suppress
	public void testNavDrawerOpenClose() {
		onView(withId(R.id.main_activity_drawer_layout)).perform(
				EspressoUtils.actionOpenDrawer());
		onView(withId(R.id.main_activity_left_drawer)).check(
				matches(ViewMatchers.isCompletelyDisplayed()));

		onView(withId(R.id.main_activity_drawer_layout)).perform(
				EspressoUtils.actionCloseDrawer());
		onView(withId(R.id.main_activity_left_drawer)).check(
				matches(not(ViewMatchers.isCompletelyDisplayed())));
	}

	/**
	 * Se o botao de Info esta aparecendo ou nao quando o NavDrawer eh aberto
	 * ps.: ha um problema de sincronizacao do espresso com o utils
	 */
	@Suppress
	public void testMenuHiddenOnNavOpen() {
		onView(withId(R.id.main_activity_drawer_layout)).perform(
				EspressoUtils.actionOpenDrawer());
		onView(withId(R.id.main_activity_left_drawer)).check(
				matches(ViewMatchers.isDisplayed()));
		onView(ViewMatchers.withId(R.id.m_main_actv_info)).check(
				ViewAssertions.matches(not(ViewMatchers.isDisplayed())));
		onView(withId(R.id.main_activity_drawer_layout)).perform(
				EspressoUtils.actionCloseDrawer());
		onView(withId(R.id.main_activity_left_drawer)).check(
				matches(not(ViewMatchers.isDisplayed())));
		onView(ViewMatchers.withId(R.id.m_main_actv_info)).check(
				ViewAssertions.matches(ViewMatchers.isDisplayed()));
	}

	/**
	 * Se o onItemClick esta levando para a atividade correta
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
