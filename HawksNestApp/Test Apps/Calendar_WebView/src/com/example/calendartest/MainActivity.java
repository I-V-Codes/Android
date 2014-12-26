package com.example.calendartest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //String url = "http://137.140.113.189:8082/cams/cam1.html";
    // WebView view = (WebView) this.findViewById(R.id.webView1);
     
    // view.loadUrl(url);
        WebView browser = (WebView) findViewById(R.id.webView1);
        WebSettings webSettings = browser.getSettings();
        webSettings.
setJavaScriptEnabled(true);
        browser.getSettings().setPluginState(WebSettings.PluginState.ON);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("https://www.google.com/calendar/embed?src=2l7dlgqcvn197hruqqgfuo8064%40group.calendar.google.com&ctz=America/New_York");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
