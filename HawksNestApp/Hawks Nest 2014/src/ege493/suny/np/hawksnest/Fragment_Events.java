package ege493.suny.np.hawksnest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Fragment_Events extends Fragment {
	
	String myUrl;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

    	View v = inflater.inflate(R.layout.events_fragment, null);
        WebView browser = (WebView) v.findViewById(R.id.eventsWeb);
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.getSettings().setPluginState(WebSettings.PluginState.ON);
        browser.setWebViewClient(new WebViewClient());

        Bundle b = getArguments();
		switch(b.getString(MainActivity.EXTRA_DORM)) {
		case "Bevier":
			browser.loadUrl("https://www.google.com/calendar/embed?src=2l7dlgqcvn197hruqqgfuo8064%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Crispell":
			browser.loadUrl("https://www.google.com/calendar/embed?src=fedn7i4s84kdj112hlnl4cu76o%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Deyo":
			browser.loadUrl("https://www.google.com/calendar/embed?src=9cnv8d1s4k6q02v2liusqel8a8%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "DuBois":
			browser.loadUrl("https://www.google.com/calendar/embed?src=rqpeb5tcd3vaev00heff1gkgsc%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Lefevre":
			browser.loadUrl("https://www.google.com/calendar/embed?src=babr5q6s0tgv2uta91d9immjbs%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Bliss":
			browser.loadUrl("https://www.google.com/calendar/embed?src=54v0avoj0jekdn10r1rcaqvaac%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Capen":
			browser.loadUrl("https://www.google.com/calendar/embed?src=h7eibqudquqjchmd17b8qk9fmo%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Gage":
			browser.loadUrl("https://www.google.com/calendar/embed?src=rqpeb5tcd3vaev00heff1gkgsc%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Scudder":
			browser.loadUrl("https://www.google.com/calendar/embed?src=b3h0cfhgat2psi831konr5jgkk%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Bouton":
			browser.loadUrl("https://www.google.com/calendar/embed?src=i4uu01icgca6gi0ptmfq8c7df4%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "College/Shango":
			browser.loadUrl("https://www.google.com/calendar/embed?src=jh41lvil0upgd6bjauscsvas9g%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Esopus":
			browser.loadUrl("https://www.google.com/calendar/embed?src=rmgliol8kjiid0633v0dde3ljo%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Lenape":
			browser.loadUrl("https://www.google.com/calendar/embed?src=32pf800mluu6pgbmvrac5d4q1o%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		default:
			break;
			
		}

	    return inflater.inflate(R.layout.events_fragment, null);
	}
}
