package br.com.aeho.gdgprosandcons;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBarActivity;
import br.com.aeho.gdgprosandcons.Utils.Constants;

public class VoteActv extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vote_actv);
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
}
