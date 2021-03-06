package ege493.sunynp.hawksnest2014;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity {
	
	public static final String ROW_ID = "row_id";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		switch (item.getItemId()) {
	      case R.id.view_ras:
	        Intent i=new Intent(this, RAList.class);
	        startActivity(i);
	        return(true);
	    }
		
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	public void onClick(View v) {
        switch(v.getId()){
            case R.id.imageButtonPQuad:
                 Intent i = new Intent(this, ChoosePDorm.class);
                 startActivity(i);
                 break;
            case R.id.imageButtonHQuad:
            	 i = new Intent(this, ChooseHDorm.class);
                 startActivity(i);
            	 break;
            case R.id.imageButtonSQuad:
            	 i = new Intent(this, ChooseSDorm.class);
                 startActivity(i); 
            	 break;
        }

	}
	
	public void onAddEditCompleted(long rowID) {
		getFragmentManager().popBackStack(); // removes top of back stack
	}   

}
