package com.knit.effulgence;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.support.v4.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class News extends Fragment implements AdapterView.OnItemClickListener{

    private static String url = "http://www.effulgencefest.com/android";

    private static final String TAG_CONTACTS = "news";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_FLAG = "flag";

    JSONArray news = null;

    ArrayList<HashMap<String, String>> contactList;
    private View v;
    private TextView tvError;
	 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		v = inflater.inflate(R.layout.news, container, false);
		contactList = new ArrayList<>();
		tvError = (TextView)v.findViewById(R.id.tvNewsError);
		MyConnection conn = new MyConnection(getActivity());
		if(conn.isConnectingToInternet()){
			GetContacts gc = new GetContacts();
			gc.execute();
		}else{
            tvError.setVisibility(View.VISIBLE);
            tvError.setText("Oops!\nNo Network detected.");
        }
		
		return v;
	}
	
	 private class GetContacts extends AsyncTask<Void, Void, Void> {
            protected void onPreExecute() {
	            super.onPreExecute();
                tvError.setVisibility(View.VISIBLE);
                tvError.setText("Loading News...");
	 
	        }
	 
	        protected Void doInBackground(Void... arg0) {
	            ServiceHandler sh = new ServiceHandler();
	 
	            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

	            if (jsonStr != null) {
	                try {
	                    JSONObject jsonObj = new JSONObject(jsonStr);
	                     
	                    news = jsonObj.getJSONArray(TAG_CONTACTS);
	 
	                    for (int i = 0; i < news.length(); i++) {
	                        JSONObject c = news.getJSONObject(i);
	                        String id = c.getString(TAG_ID);
	                        String name = c.getString(TAG_NAME);
                            int flag = c.getInt(TAG_FLAG);
                            if(flag == 1)
                                name = "[LATEST]\n"+name;

                            HashMap<String, String> contact = new HashMap<>();
                            contact.put(TAG_ID, id);
	                        contact.put(TAG_NAME, name);
                            contactList.add(contact);
	                    }
	                } catch (JSONException e) {
	                    e.printStackTrace();
	                }
	            } else {
	                Log.e("ServiceHandler", "Couldn't get any data from the url");
	            }
	            return null;
	        }
	 
	        @Override
	        public void onPostExecute(Void result) {
	            super.onPostExecute(result);
	            // Dismiss the progress dialog

                tvError.setVisibility(View.INVISIBLE);
	            
	            ListAdapter adapter = new SimpleAdapter(
	                    getActivity(), contactList,
	                    R.layout.news_list, new String[] { TAG_NAME, TAG_ID
	                             }, new int[] { R.id.name, R.id.u_id });

	            ListView lv = (ListView) v.findViewById(R.id.news_list);
			      lv.setAdapter(adapter);
	        }

	    }
    @Override
    public void onItemClick(AdapterView <? > parent, View view, int position, long id){
        //Intent intent = new Intent();
    }
}