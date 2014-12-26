package ege493.test.hawksnesttabs;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	ActionBar actionBar;

    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		actionBar = getActionBar(); // Get reference to ActionBar
		
		//Using a different Action Bar, the tabs work well, but...
		//I'm trying to get rid of the title/icon/options menu. The Theme.Holo.NoActionBar
		//causes it to crash, and I can't get an 'onCreateOptionsMenu' to work.
		//Trying to allow a menu to work through hitting the menu button on the phone, but I do not want an
		//option for it in the action bar, or an action bar at all (which, I currently have no action bar)
		//Goal for this:::: Use the menu button to bring you back to dorm selection if you are already in the app

		// 1. Enable ActionBar navigation tabs
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);

		// 2. Add the tabs
		Tab hasbrouckTab = actionBar.newTab();
		Tab parkerTab = actionBar.newTab();
		Tab southTab = actionBar.newTab();

		String label1 = getResources().getString(R.string.hasbrouck);
		hasbrouckTab.setText(label1).setTabListener(
				new TabListener<Fragment_Has>(this, R.id.quadParent,
						Fragment_Has.class));

		String label2 = getResources().getString(R.string.parker);
		parkerTab.setText(label2).setTabListener(
				new TabListener<Fragment_Parker>(this, R.id.quadParent,
						Fragment_Parker.class));

		String label3 = getResources().getString(R.string.south);
		southTab.setText(label3).setTabListener(
				new TabListener<Fragment_South>(this, R.id.quadParent,
						Fragment_South.class));

		actionBar.addTab(hasbrouckTab);
		actionBar.addTab(parkerTab);
		actionBar.addTab(southTab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_home, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.action_settings:
			Toast.makeText(this, "Acton settings selected", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		return true;
	}
	
	//Some sort of onClick method. Trying to figure out how
	//to create a single activity/fragment, but load data
	//based on a certain button ID.
	//my guess is doing a switch case statement in onCreate that gets the item ID of what button
	//started the program
	
	//psuedo code for onClick
	/*
	 *
	 * public void onClick () {
	 *     Intent intent = new Intent(this, DormInfo.class)
	 *     startActivity(intent)
	 * }
	 * 
	 * I'm not sure if this will send the ID that created the activity, though
	 * have to figure out how to load data in a new activity based on button click
	 * idea here:
	 * load a new activity with 3 fragmented tabs, RA, Event, Duty
	 * based on ID of button, load data from that hall into fragments
	 */
}
