package ege493.suny.np.hawksnest;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class TabListener <T extends Fragment> implements ActionBar.TabListener{
	private Fragment fragment;
	private int fragmentContainer;
	private final Activity activity;
	private final Class<T> fragmentClass;

	/**
	 * Constructor used each time a new tab is created.
	 * 
	 * @param activity
	 *            The host Activity, used to instantiate the fragment
	 * @param tag
	 *            The identifier tag for the fragment
	 * @param fragmentClass
	 *            The fragment's Class, used to instantiate the fragment
	 */
	public TabListener(Activity activity, int fragmentContainer,
			Class<T> fragmentClass) {
		this.activity = activity;
		this.fragmentContainer = fragmentContainer;
		this.fragmentClass = fragmentClass;
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// User selected the already selected tab. Usually do nothing.
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// Check if the fragment is already initialized
		if (fragment == null) {
			// If not, instantiate and add it to the Activity
			fragment = Fragment.instantiate(activity, fragmentClass.getName());
			fragment = Fragment.instantiate(activity, fragmentClass.getName(), (Bundle) tab.getTag());
			ft.add(fragmentContainer, fragment);
		} else {
			ft.attach(fragment);
		}
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		if (fragment != null) {
			// Detach the fragment, because another one is being attached
			ft.detach(fragment);
		}
	}
}