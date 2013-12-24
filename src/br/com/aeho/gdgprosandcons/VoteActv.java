package br.com.aeho.gdgprosandcons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import br.com.aeho.gdgprosandcons.Utils.Constants;

public class VoteActv extends ActionBarActivity implements
		ActionBar.TabListener, ViewPager.OnPageChangeListener {

	private ActionBar mActionBar;
	private ViewPager mViewPager;
	public static final int NEW_POSTIT_ACTV_CODE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vote_actv);
		mViewPager = (ViewPager) findViewById(R.id.vote_actv_pager);
		mActionBar = getSupportActionBar();
		mActionBar.addTab(mActionBar.newTab().setText(getString(R.string.ruim))
				.setTabListener(this));
		mActionBar.addTab(mActionBar.newTab().setText(getString(R.string.bom))
				.setTabListener(this));
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		mViewPager.setAdapter(new VoteMoodPagerAdapter(
				getSupportFragmentManager()));
		mViewPager.setOnPageChangeListener(this);

	}

	public class VoteMoodPagerAdapter extends FragmentPagerAdapter {

		public VoteMoodPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment mFragment = new VoteFragment();
			Bundle mArgs = new Bundle();
			if (position == 0) {
				mArgs.putInt(Constants.PAGER_MOOD, Constants.PAGER_MOOD_BAD);
			} else {
				mArgs.putInt(Constants.PAGER_MOOD, Constants.PAGER_MOOD_GOOD);
			}
			mFragment.setArguments(mArgs);
			return mFragment;
		}

		@Override
		public int getCount() {
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return position == 0 ? getString(R.string.ruim)
					: getString(R.string.bom);
		}

	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {

	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onPageSelected(int position) {
		mActionBar.setSelectedNavigationItem(position);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.vote_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.m_vote_menu_newPost:
			startActivityForResult(new Intent(VoteActv.this,
					NewPostItActv.class), NEW_POSTIT_ACTV_CODE);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
