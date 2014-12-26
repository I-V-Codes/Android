package com.example.parsingjson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	 
    EditText etResponse;
    TextView tvIsConnected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        // get reference to the views
        etResponse = (EditText) findViewById(R.id.etResponse);
        tvIsConnected = (TextView) findViewById(R.id.tvIsConnected);
 
        // check if you are connected or not
        if(isConnected()){
            tvIsConnected.setBackgroundColor(0xFF00CC00);
            tvIsConnected.setText("You are connected");
        }
        else{
            tvIsConnected.setText("You are NOT conncted");
        }
 
        // call AsynTask to perform network operation on separate thread
        new HttpAsyncTask().execute("https://spreadsheets.google.com/feeds/list/1FhoITgGJCWlnppyfP5orKPtqMCOSL-BmKKyTlAiNjIQ/od6/public/values?alt=json");
    }
 
    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {
 
            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
 
            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();
 
            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";
 
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
 
        return result;
    }
 
    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;
 
        inputStream.close();
        return result;
 
    }
 
    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected())
                return true;
            else
                return false;  
    }
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
 
            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
            try {
            	JSONObject json = new JSONObject(result);

            	String str = "";

            	JSONArray a = json.getJSONObject("feed").getJSONArray("entry");
            	int listlength = json.getJSONObject("feed").getJSONArray("entry").length();
            	str += "names: "+a.getJSONObject(0).names();
            	str += "\n--------\n";
            	for(int i = 0; i<listlength; i++)
            	{
            		str += "Entry "+(i+1)+":\n";
            		
	            	str += "  -Name: "+a.getJSONObject(i).getString("gsx$name");
	            	str = str.replace("{", "");
	            	str = str.replace("}", "");
	            	str = str.replace("\"", "");
	            	str = str.replace("$t:", "");
	            	str += "\n";
	            	
	            	str += "  -Dorm: "+a.getJSONObject(i).getString("gsx$dorm");
	            	str = str.replace("{", "");
	            	str = str.replace("}", "");
	            	str = str.replace("\"", "");
	            	str = str.replace("$t:", "");
	            	str += "\n";
	            	
	            	str += "  -Room: "+a.getJSONObject(i).getString("gsx$room");
	            	str = str.replace("{", "");
	            	str = str.replace("}", "");
	            	str = str.replace("\"", "");
	            	str = str.replace("$t:", "");
	            	str += "\n";
	            	
	            	str += "  -EXT#: "+a.getJSONObject(i).getString("gsx$ext");
	            	str = str.replace("{", "");
	            	str = str.replace("}", "");
	            	str = str.replace("\"", "");
	            	str = str.replace("$t:", "");
	            	str += "\n";
            	}
            	
            	etResponse.setText(str);
            	//etResponse.setText(json.toString(1));
            	
            	} catch (JSONException e) {
            	// TODO Auto-generated catch block
            	e.printStackTrace();
            	}
        }
    }
}