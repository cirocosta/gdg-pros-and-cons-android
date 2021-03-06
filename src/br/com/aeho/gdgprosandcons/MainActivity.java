package br.com.aeho.gdgprosandcons;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements
		View.OnClickListener {

	private static int sDrawerStatus = 0;
	private ListView mLeftDrawer;
	private View mNavDrawerHeader, mNavDrawerFooter;
	private DrawerLayout mDrawerLayout;
	private NavDrawerListAdapter mListAdapter;
	private ActionBarDrawerToggle mDrawerToggle;
	private Button mButtonFooter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		initializeUi();
		initializeAdapters();

		mLeftDrawer.addHeaderView(mNavDrawerHeader, null, false);
		mLeftDrawer.addFooterView(mNavDrawerFooter);
		mLeftDrawer.setAdapter(mListAdapter);
		mLeftDrawer.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				position--;
				selectFragFromItem(position);
			}
		});
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		mButtonFooter.setOnClickListener(this);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		if (savedInstanceState == null) {
			selectFragFromItem(0);
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	private void selectFragFromItem(int position) {
		switch (position) {
		case 0:
			Fragment fragment = new ListaFragment();
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.main_activity_content_frame, fragment)
					.commit();
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}
		mDrawerLayout.closeDrawer(mLeftDrawer);
	}

	private void initializeAdapters() {

		mListAdapter = new NavDrawerListAdapter(MainActivity.this,
				R.layout.main_activity_drawer_row);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_navigation_drawer, R.string.app_name,
				R.string.app_name) {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				sDrawerStatus = 0;
				supportInvalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				sDrawerStatus = 1;
				supportInvalidateOptionsMenu();
			}
		};
	}

	private static class NavItemHolder {
		TextView tvNome;
		ImageView ivIcon;
	}

	public class NavDrawerListAdapter extends ArrayAdapter<String> {

		final Context context;
		final int resource;
		final String items[];

		public NavDrawerListAdapter(Context context, int resource) {
			super(context, resource);
			this.context = context;
			this.resource = resource;
			this.items = context.getResources().getStringArray(
					R.array.navdrawer_items);
		}

		@Override
		public int getCount() {
			return items.length;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			NavItemHolder holder;
			if (convertView == null) {
				holder = new NavItemHolder();
				LayoutInflater inflater = ((Activity) context)
						.getLayoutInflater();
				convertView = inflater.inflate(
						R.layout.main_activity_drawer_row, parent, false);
				holder.tvNome = (TextView) convertView
						.findViewById(R.id.main_activity_drawer_row_tvNome);
				holder.ivIcon = (ImageView) convertView
						.findViewById(R.id.main_activity_drawer_row_ivIcon);
				convertView.setTag(holder);
			} else {
				holder = (NavItemHolder) convertView.getTag();
			}
			holder.tvNome.setText(items[position]);
			switch (position) {
			case 0:
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			}
			return convertView;
		}

	}

	private void initializeUi() {
		final LayoutInflater inflater = getLayoutInflater();
		mLeftDrawer = (ListView) findViewById(R.id.main_activity_left_drawer);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.main_activity_drawer_layout);
		mNavDrawerHeader = inflater.inflate(
				R.layout.main_activity_drawer_header, null);
		mNavDrawerFooter = inflater.inflate(
				R.layout.main_activity_drawer_footer, null);
		mButtonFooter = (Button) mNavDrawerFooter
				.findViewById(R.id.main_activity_drawer_footer_bFooter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_actv, menu);
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		MenuItem mInfo = menu.findItem(R.id.m_main_actv_info);
		if (sDrawerStatus == 0) {
			mInfo.setEnabled(true).setVisible(true);
		} else {
			mInfo.setEnabled(false).setVisible(false);
		}
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			if (sDrawerStatus == 0) {
				mDrawerLayout.openDrawer(mLeftDrawer);
			} else {
				mDrawerLayout.closeDrawer(mLeftDrawer);
			}
			return true;
		case R.id.m_main_actv_info:
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.main_activity_drawer_footer_bFooter:

			break;
		}
	}

}
