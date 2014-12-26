package ege493.suny.np.hawksnest;


import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class DormInfo extends Activity {
	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dorm);

		// Set up the action bar.

		actionBar = getActionBar(); // Get reference to ActionBar
		
		//Using a different Action Bar, the tabs work well, but...
		//I'm trying to get rid of the title/icon/options menu. The Theme.Holo.NoActionBar
		//causes it to crash, and I can't get an 'onCreateOptionsMenu' to work.
		//Trying to allow a menu to work through hitting the menu button on the phone, but I do not want an
		//option for it in the action bar, or an action bar at all (which, I currently have no action bar)
		//Goal for this:::: Use the menu button to bring you back to dorm selection if you are already in the app

		// 1. Enable ActionBar navigation tabs
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);


		// 2. Add the tabs
		Tab peopleTab = actionBar.newTab();
		Tab eventsTab = actionBar.newTab();
		Tab hoursTab = actionBar.newTab();

		String label1 = getResources().getString(R.string.ra_list);
		peopleTab.setText(label1).setTabListener(
				new TabListener<Fragment_RA>(this, R.id.dormParent,
						Fragment_RA.class));

		String label2 = getResources().getString(R.string.dorm_events);
		eventsTab.setText(label2).setTabListener(
				new TabListener<Fragment_Events>(this, R.id.dormParent,
						Fragment_Events.class));

		String label3 = getResources().getString(R.string.dorm_hours);
		hoursTab.setText(label3).setTabListener(
				new TabListener<Fragment_Hours>(this, R.id.dormParent,
						Fragment_Hours.class));

		/*actionBar.addTab(peopleTab);
		actionBar.addTab(eventsTab);
		actionBar.addTab(hoursTab);*/
		
		//--------------------------------------------------------
		//Get the buttonID from the button that started the activity
		//--------------------------------------------------------
		
		String value = getIntent().getExtras().getString(MainActivity.EXTRA_DORM);
		
		Bundle b = new Bundle();
		b.putString(MainActivity.EXTRA_DORM, value);
		
		peopleTab.setTag(b);
		eventsTab.setTag(b);
		hoursTab.setTag(b);
		
		actionBar.addTab(peopleTab);
		actionBar.addTab(eventsTab);
		actionBar.addTab(hoursTab);
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

}
