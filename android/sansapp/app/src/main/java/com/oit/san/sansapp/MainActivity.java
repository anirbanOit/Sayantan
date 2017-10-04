package com.oit.san.sansapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    private static String url = "http://profile.getsandbox.com/users";

    ArrayList<HashMap<String, String>> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list);
        new GetContacts().execute();

    }


    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            ConnectMe sh = new ConnectMe();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONArray jsonArray = new JSONArray(jsonStr);


                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject m = jsonArray.getJSONObject(i);
                        String firstName = m.getString("firstName");
                        String lastName = m.getString("lastName");
                        String gender = m.getString("gender");
                        String dob = m.getString("dob");
                        String photo = m.getString("photo");
                        String dept = m.getString("dept");

                        Log.d("san",""+firstName);
                        Log.d("san",""+lastName);
                        Log.d("san",""+gender);


                        // tmp hash map for single user detail
                        HashMap<String, String> users = new HashMap<>();

                        // adding each child node to HashMap key => value
                        users.put("name", firstName+" "+lastName);
                        users.put("dob", dob);
                        users.put("dept", dept);
                        users.put("photo", photo);

                        // adding contact to contact list
                        userList.add(users);


                    }




                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }
            return null;
        }

        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            CustomAdapter myAdapter = new CustomAdapter(MainActivity.this, userList);
            lv.setAdapter(myAdapter);

        }

    }


}
