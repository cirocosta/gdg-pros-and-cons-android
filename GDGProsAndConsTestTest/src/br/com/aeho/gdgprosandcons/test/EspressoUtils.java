package br.com.aeho.gdgprosandcons.test;

import org.hamcrest.Matcher;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.google.android.apps.common.testing.ui.espresso.UiController;
import com.google.android.apps.common.testing.ui.espresso.ViewAction;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

public class EspressoUtils {

	public static ViewAction actionOpenDrawer() {
		return new ViewAction() {
			@Override
			public Matcher<View> getConstraints() {
				return ViewMatchers.isAssignableFrom(DrawerLayout.class);
			}

			@Override
			public String getDescription() {
				return "open drawer";
			}

			@Override
			public void perform(UiController uiController, View view) {
				((DrawerLayout) view).openDrawer(GravityCompat.START);
			}
		};
	}

	public static ViewAction actionCloseDrawer() {
		return new ViewAction() {
			@Override
			public Matcher<View> getConstraints() {
				return ViewMatchers.isAssignableFrom(DrawerLayout.class);
			}

			@Override
			public String getDescription() {
				return "close drawer";
			}

			@Override
			public void perform(UiController uiController, View view) {
				((DrawerLayout) view).closeDrawer(GravityCompat.START);
			}
		};
	}

}
