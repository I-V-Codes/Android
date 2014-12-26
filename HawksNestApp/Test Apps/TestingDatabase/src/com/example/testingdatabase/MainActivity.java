package com.example.testingdatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {
  private CommentsDataSource datasource;
  //private ParseJSON datastuff;

  @Override
  public void onCreate(Bundle savedInstanceState) {
	System.out.println("0000");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    System.out.println("1");
    //create new object of CommentsDataSource
    datasource = new CommentsDataSource(this);
    datasource.open();
    new HttpAsyncTask().execute("https://spreadsheets.google.com/feeds/list/1FhoITgGJCWlnppyfP5orKPtqMCOSL-BmKKyTlAiNjIQ/od6/public/values?alt=json");
    System.out.println("2");
    List<Comment> values = datasource.getAllComments();
    // use the SimpleCursorAdapter to show the
    // elements in a ListView
    System.out.println("19");
    ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
        android.R.layout.simple_list_item_1, values);
    setListAdapter(adapter);
    System.out.println("Successuuuu");
  }

  // Will be called via the onClick attribute
  // of the buttons in main.xml
  
  public void addData(){
	  //@SuppressWarnings("unchecked")
  }
  
  /*public void onClick(View view) {
    @SuppressWarnings("unchecked")
    ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();
    Comment comment = null;
    switch (view.getId()) {
    case R.id.add:
      String[] comments = new String[] { "Cool", "Very nice", "Hate it" };
      int nextInt = new Random().nextInt(3);
      // save the new comment to the database
      
      comment = datasource.createComment(comments[nextInt]);
      adapter.add(comment);
      break;
    case R.id.delete:
      if (getListAdapter().getCount() > 0) {
        comment = (Comment) getListAdapter().getItem(0);
        datasource.deleteComment(comment);
        adapter.remove(comment);
      }
      break;
    }
    adapter.notifyDataSetChanged();
  }*/

  @Override
  protected void onResume() {
    datasource.open();
    super.onResume();
  }

  @Override
  protected void onPause() {
    datasource.close();
    super.onPause();
  }

	public static String GET(String url){
	    InputStream inputStream = null;
	    String result = "";
	    try {
	    	System.out.println("3");
	        // create HttpClient
	        HttpClient httpclient = new DefaultHttpClient();
	        System.out.println("4");
	        // make GET request to the given URL
	        HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
	        System.out.println("5");
	        // receive response as inputStream
	        inputStream = httpResponse.getEntity().getContent();
	        System.out.println("6");
	        // convert inputstream to string
	        if(inputStream != null)
	            result = convertInputStreamToString(inputStream);
	        else
	            result = "Did not work!";
	
	    } catch (Exception e) {
	    	System.out.println("7");
	        Log.d("InputStream", e.getLocalizedMessage());
	    }
	
	    return result;
	}
	
	private static String convertInputStreamToString(InputStream inputStream) throws IOException{
	    BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
	    String line = "";
	    String result = "";
	    System.out.println("8");
	    while((line = bufferedReader.readLine()) != null)
	        result += line;
	
	    inputStream.close();
	    return result;
	}
	
	public class HttpAsyncTask extends AsyncTask<String, Void, String> {
	    @Override
	    public String doInBackground(String... urls) {
	    	System.out.println("9");
	        return GET(urls[0]);
	    }
	    // onPostExecute displays the results of the AsyncTask.
	    @Override
	    public void onPostExecute(String result) {
	        //Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
	        try {
	        	JSONObject json = new JSONObject(result);
	        	System.out.println("10");
	        	//String str = "";
	        	ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();
	      	  	Comment comment = null;
	        	String comments = "hi";
	        	String name;
	        	String dorm;
	        	String room;
	        	String ext;
	        	System.out.println("11");
	        	JSONArray a = json.getJSONObject("feed").getJSONArray("entry");
	        	int listlength = json.getJSONObject("feed").getJSONArray("entry").length();
	        	//str += "names: "+a.getJSONObject(0).names();
	        	//str += "\n--------\n";
	        	System.out.println("12");
	        	for(int i = 0; i<listlength; i++)
	        	{
	        		//str += "Entry "+(i+1)+":\n";
	        		System.out.println("13");
	            	//str += "  -Name: "+a.getJSONObject(i).getString("gsx$name");
	            	name = a.getJSONObject(i).getString("gsx$name");
	            	name = name.replace("{", "");
	            	name = name.replace("}", "");
	            	name = name.replace("\"", "");
	            	name = name.replace("$t:", "");
	            	//str += "\n";
	            	System.out.println("14");
	            	
	            	//str += "  -Dorm: "+a.getJSONObject(i).getString("gsx$dorm");
	            	dorm = a.getJSONObject(i).getString("gsx$dorm");
	            	dorm = dorm.replace("{", "");
	            	dorm = dorm.replace("}", "");
	            	dorm = dorm.replace("\"", "");
	            	dorm = dorm.replace("$t:", "");
	            	//str += "\n";
	            	System.out.println("15");
	            	//str += "  -Room: "+a.getJSONObject(i).getString("gsx$room");
	            	room = a.getJSONObject(i).getString("gsx$room");
	            	room = room.replace("{", "");
	            	room = room.replace("}", "");
	            	room = room.replace("\"", "");
	            	room = room.replace("$t:", "");
	            	//str += "\n";
	            	System.out.println("16");
	            	//str += "  -EXT#: "+a.getJSONObject(i).getString("gsx$ext");
	            	ext = a.getJSONObject(i).getString("gsx$ext");
	            	ext = ext.replace("{", "");
	            	ext = ext.replace("}", "");
	            	ext = ext.replace("\"", "");
	            	ext = ext.replace("$t:", "");
	            	//str += "\n";
	            	System.out.println("17");
	            	comment = datasource.createComment(comments, name, dorm, room, ext);
	                adapter.add(comment);
	                adapter.notifyDataSetChanged();
	        	}
	        	
	        	//etResponse.setText(str);
	        	//etResponse.setText(json.toString(1));
	        	
	        	} catch (JSONException e) {
	        		System.out.println("18");
	        	// TODO Auto-generated catch block
	        	e.printStackTrace();
	        	}
	        return;
	    }
	}
  
} 