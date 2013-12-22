package br.com.aeho.gdgprosandcons;

import android.app.Activity;
import android.content.Context;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private static int drawerStatus = 0;
	private ListView leftDrawer;
	private View navDrawerHeader, navDrawerFooter;
	private DrawerLayout drawerLayout;
	private NavDrawerListAdapter listAdapter;
	private ActionBarDrawerToggle drawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		initialize_ui();
		initialize_adapters();
		leftDrawer.addHeaderView(navDrawerHeader);
		leftDrawer.addFooterView(navDrawerFooter);
		leftDrawer.setAdapter(listAdapter);
		leftDrawer.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				position--;
				switch (position) {
				case 0:
					Fragment fragment = new ListaFragment();
					getSupportFragmentManager()
							.beginTransaction()
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
				drawerLayout.closeDrawer(leftDrawer);
			}
		});
		drawerLayout.setDrawerListener(drawerToggle);
	}

	private void initialize_adapters() {

		listAdapter = new NavDrawerListAdapter(MainActivity.this,
				R.layout.main_activity_drawer_row);

		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_action_about, R.string.app_name,
				R.string.app_name) {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				drawerStatus = 0;
				supportInvalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				drawerStatus = 1;
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

	private void initialize_ui() {
		final LayoutInflater inflater = getLayoutInflater();
		leftDrawer = (ListView) findViewById(R.id.main_activity_left_drawer);
		drawerLayout = (DrawerLayout) findViewById(R.id.main_activity_drawer_layout);
		navDrawerHeader = inflater.inflate(
				R.layout.main_activity_drawer_header, null);
		navDrawerFooter = inflater.inflate(
				R.layout.main_activity_drawer_footer, null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}

}
