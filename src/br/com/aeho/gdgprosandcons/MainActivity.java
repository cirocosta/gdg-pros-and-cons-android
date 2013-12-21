package br.com.aeho.gdgprosandcons;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	private ListView leftDrawer;
	private DrawerLayout drawerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		initialize_ui();
	}

	private void initialize_ui() {
		leftDrawer = (ListView) findViewById(R.id.main_activity_left_drawer);
		drawerLayout = (DrawerLayout) findViewById(R.id.main_activity_drawer_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
