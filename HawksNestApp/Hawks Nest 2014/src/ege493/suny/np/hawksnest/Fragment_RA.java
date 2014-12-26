package ege493.suny.np.hawksnest;

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

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment_RA extends Fragment{
    public static TextView getResponse;
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			
			View v = inflater.inflate(R.layout.people_fragment, null);
			getResponse = (TextView) v.findViewById(R.id.getResponse);
			Bundle b = getArguments();
			switch(b.getString(MainActivity.EXTRA_DORM)) {
			case "Bevier":
				new HttpAsyncTask()
					.execute("https://spreadsheets.google.com/feeds/list/1FhoITgGJCWlnppyfP5orKPtqMCOSL-BmKKyTlAiNjIQ/od6/public/values?alt=json");
				break;
				
			case "Crispell":
				new HttpAsyncTask()
					.execute("https://spreadsheets.google.com/feeds/list/1Yd1BBg7wGYszE-McUuHLMkrypOKFPsQLYxpwkShCAiw/od6/public/values?alt=json");
				break;
				
			case "Deyo":
				new HttpAsyncTask()
					.execute("https://spreadsheets.google.com/feeds/list/1hBoQxk-p2bgvd76c-nv5Z2dvfaY-CDJtlt5R1mwa2LY/od6/public/values?alt=json");
				break;
				
			case "DuBois":
				new HttpAsyncTask()
					.execute("https://spreadsheets.google.com/feeds/list/1k74V0ttQzAA3A0Xzj7-3fgrhaa905BZ8CVuhLwb1uUg/od6/public/values?alt=json");
				break;
				
			case "Lefevre":
				new HttpAsyncTask()
					.execute("https://spreadsheets.google.com/feeds/list/1zARZ6plnfOCrj1kH-QATrcbgS6Bjne2TYJWsLlsiEE0/od6/public/values?alt=json");
				break;
				
			case "Bliss":
				new HttpAsyncTask()
					.execute("https://spreadsheets.google.com/feeds/list/1ZpzkbJvcCKE5Cf_GnwQqM_xsJWc2iYVhkWi3FyZXc9s/od6/public/values?alt=json");
				break;
				
			case "Capen":
				new HttpAsyncTask()
					.execute("https://spreadsheets.google.com/feeds/list/1PcMWsS8jKY9gFdho95aco7GSWnCuTW4CK9IMi9kY0gM/od6/public/values?alt=json");
				break;
				
			case "Gage":
				new HttpAsyncTask()
					.execute("https://spreadsheets.google.com/feeds/list/1HKNLxdRGLRmOBZb1OL2kq1oK8ZlhH2BXNzNVEQrG-nY/od6/public/values?alt=json");
				break;
				
			case "Scudder":
				new HttpAsyncTask()
					.execute("https://spreadsheets.google.com/feeds/list/1QhYRVHYmQE4BheebyRjBkYjewjpkB4j_JVZ30HCNDvk/od6/public/values?alt=json");
				break;
				
			case "Bouton":
				new HttpAsyncTask()
					.execute("https://spreadsheets.google.com/feeds/list/164X_uRScperKfOXYPwA7Cor1tGJIi0LKh2IpJR5757k/od6/public/values?alt=json");
				break;
				
			case "College/Shango":
				new HttpAsyncTask()
					.execute("https://spreadsheets.google.com/feeds/list/1UC6qBoJaMg186yK4HCdpP_COx-rdvm5WAscmeCuSjoU/od6/public/values?alt=json");
				break;
				
			case "Esopus":
				new HttpAsyncTask()
					.execute("https://spreadsheets.google.com/feeds/list/1MrNoiXIwoPzWzL498x0rsj27vAfthhRf8ExZraG-j5k/od6/public/values?alt=json");
				break;
				
			case "Lenape":
				new HttpAsyncTask()
					.execute("https://spreadsheets.google.com/feeds/list/1zARZ6plnfOCrj1kH-QATrcbgS6Bjne2TYJWsLlsiEE0/od6/public/values?alt=json");
				break;
				
			default:
				getResponse.setText("@string/json_error");
				break;
				
			}
			//getResponse.setText("Details of " + b.getString(MainActivity.EXTRA_DORM));
			
			return v;
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
    
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
        	
            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            try {
            	JSONObject json = new JSONObject(result);

            	String str = "";

            	JSONArray a = json.getJSONObject("feed").getJSONArray("entry");
            	int listlength = json.getJSONObject("feed").getJSONArray("entry").length();
            	//str += "names: "+a.getJSONObject(0).names();
            	//str += "\n--------\n";
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
            	
            	getResponse.setText(str);
            	//etResponse.setText(json.toString(1));
            	
            	} catch (JSONException e) {
            	// TODO Auto-generated catch block
            	e.printStackTrace();
            	}
        }
    }
}
