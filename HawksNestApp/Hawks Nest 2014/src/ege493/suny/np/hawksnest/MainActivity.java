package ege493.suny.np.hawksnest;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	public final static String EXTRA_DORM = "ege493.Dorm";

	ActionBar actionBar;

    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		actionBar = getActionBar(); // Get reference to ActionBar

		// 1. Enable ActionBar navigation tabs
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setDisplayShowHomeEnabled(true);

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
		case R.id.action_about:
			Intent i = new Intent(this, AboutUs.class);
			startActivity(i);
			Toast.makeText(this, "Acton about selected", Toast.LENGTH_SHORT).show();
			break;
		
		default:
			break;
		}
		return true;
	}
	
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.buttonBevier:
			Intent i = new Intent(this, DormInfo.class);
			String dorm = "Bevier";
			i.putExtra(EXTRA_DORM, dorm);
			startActivity(i);
			break;
			
		case R.id.buttonCrispell:
			i = new Intent(this, DormInfo.class);
			dorm = "Crispell";
			i.putExtra(EXTRA_DORM, dorm);
			startActivity(i);
			break;
			
		case R.id.buttonDeyo:
			i = new Intent(this, DormInfo.class);
			dorm = "Deyo";
			i.putExtra(EXTRA_DORM, dorm);
			startActivity(i);
			break;
			
		case R.id.buttonDuBois:
			i = new Intent(this, DormInfo.class);
			dorm = "DuBois";
			i.putExtra(EXTRA_DORM, dorm);
			startActivity(i);
			break;
			
		case R.id.buttonLefevre:
			i = new Intent(this, DormInfo.class);
			dorm = "Lefevre";
			i.putExtra(EXTRA_DORM, dorm);
			startActivity(i);
			break;
			
		case R.id.buttonBouton:
			i = new Intent(this, DormInfo.class);
			dorm = "Bouton";
			i.putExtra(EXTRA_DORM, dorm);
			startActivity(i);
			break;
		case R.id.buttonBliss:
			i = new Intent(this, DormInfo.class);
			dorm = "Bliss";
			i.putExtra(EXTRA_DORM, dorm);
			startActivity(i);
			break;
			
		case R.id.buttonCapen:
			i = new Intent(this, DormInfo.class);
			dorm = "Capen";
			i.putExtra(EXTRA_DORM, dorm);
			startActivity(i);
			break;
			
		case R.id.buttonCollango:
			i = new Intent(this, DormInfo.class);
			dorm = "College/Shango";
			i.putExtra(EXTRA_DORM, dorm);
			startActivity(i);
			break;
			
		case R.id.buttonGage:
			i = new Intent(this, DormInfo.class);
			dorm = "Gage";
			i.putExtra(EXTRA_DORM, dorm);
			startActivity(i);
			break;
			
		case R.id.buttonScudder:
			i = new Intent(this, DormInfo.class);
			dorm = "Scudder";
			i.putExtra(EXTRA_DORM, dorm);
			startActivity(i);
			break;
			
		case R.id.buttonEsopus:
			i = new Intent(this, DormInfo.class);
			dorm = "Esopus";
			i.putExtra(EXTRA_DORM, dorm);
			startActivity(i);
			break;
			
		case R.id.buttonLenape:
			i = new Intent(this, DormInfo.class);
			dorm = "Lenape";
			i.putExtra(EXTRA_DORM, dorm);
			startActivity(i);
			break;
		}
	}
}
