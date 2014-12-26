package ege493.suny.np.hawksnest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Fragment_Hours extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	View v = inflater.inflate(R.layout.hours_fragment, null);
        WebView browser = (WebView) v.findViewById(R.id.hoursWeb);
        //browser.addJavascriptInterface(new WebAppInterface(this), "Android");
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.getSettings().setPluginState(WebSettings.PluginState.ON);
        browser.setWebViewClient(new WebViewClient());

        Bundle b = getArguments();
		switch(b.getString(MainActivity.EXTRA_DORM)) {
		case "Bevier":
			browser.loadUrl("https://www.google.com/calendar/embed?src=lspj41hsfdpuqvkjtcil62p4fc%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Crispell":
			browser.loadUrl("https://www.google.com/calendar/embed?src=i9qlhigm8ghhc8v8c8piflqq00%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Deyo":
			browser.loadUrl("https://www.google.com/calendar/embed?src=ldmo7spfhkdgc1jur104rh3e6g%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "DuBois":
			browser.loadUrl("https://www.google.com/calendar/embed?src=9uaahkjpadd423001a66f1tg9c%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Lefevre":
			browser.loadUrl("https://www.google.com/calendar/embed?src=getd8q0a1kjrht98jk3rcqjb6o%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Bliss":
			browser.loadUrl("https://www.google.com/calendar/embed?src=i0eeltjthdjb3mbjuveondrcbg%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Capen":
			browser.loadUrl("https://www.google.com/calendar/embed?src=2e7vflj1r6cavl61hji7r937fg%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Gage":
			browser.loadUrl("https://www.google.com/calendar/embed?src=gnkqjvu5pp7tcvrondfk3to31k%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Scudder":
			browser.loadUrl("https://www.google.com/calendar/embed?src=veva4f57ck67l0ecko97vevn9k%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "Bouton":
			browser.loadUrl("https://www.google.com/calendar/embed?src=r9pgai9raamfah5md2hqmg0log%40group.calendar.google.com&ctz=America/New_York");
			break;
			
		case "College/Shango":
			browser.loadUrl("https://www.google.com/calendar/embed?src=dkrhggp7kv0o1bl4sdladm9nps%40group.calendar.google.com&ctz=America/New_York");
			break;

		case "Esopus":
			browser.loadUrl("https://www.google.com/calendar/embed?src=lv0puq1ad2qtn6btvfbqqkdnoc%40group.calendar.google.com&ctz=America/New_York");
			break;

		case "Lenape":
			browser.loadUrl("https://www.google.com/calendar/embed?src=sn645874t35ccas9sbmhtitfec%40group.calendar.google.com&ctz=America/New_York");
			break;

		default:
			break;

		}
        
	    return inflater.inflate(R.layout.hours_fragment, null);
	}
}
