package com.banjir.info.infobanjir;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by USER on 15/2/2017.
 */
public class n9_activity extends AppCompatActivity {

    private String TAG = n9_activity.class.getSimpleName();
    private ListView lv;

    ArrayList<HashMap<String, String>> banjirList;
    HashMap<String, String> data1 = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.n9_layout);

        banjirList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);

        new GetData().execute();
    }

    private class GetData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(n9_activity.this,"Sedang memproses ...",Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://banjir-api.herokuapp.com/api/v1/reports.json?negeri=negerisembilan";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray data = jsonObj.getJSONArray("data");
                    if(data.length() != 0) {
                        // looping through All data
                        for (int i = 0; i < data.length(); i++) {
                            JSONObject c = data.getJSONObject(i);
                            String paras_air = "Paras Air : " + c.getString("paras_air");
                            String nama_laluan = c.getString("nama_laluan");
                            String dikemaskini = "Dikemaskini : " + c.getString("dikemaskini");
                            String status = "Status Semasa : " + c.getString("status");

                            // adding each child node to HashMap key => value
                            data1.put("paras_air", paras_air);
                            data1.put("nama_laluan", nama_laluan);
                            data1.put("dikemaskini", dikemaskini);
                            data1.put("status", status);

                            // adding contact to contact list
                            banjirList.add(data1);
                        }
                    } else {

                        String msg = "Tiada sebarang maklumat banjir !";
                        data1.put("msg", msg);

                        banjirList.add(data1);
                    }

                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
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
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            ListAdapter adapter = new SimpleAdapter(n9_activity.this, banjirList,
                    R.layout.list_item, new String[]{"nama_laluan", "paras_air", "status", "dikemaskini", "msg"},
                    new int[]{R.id.nama_laluan, R.id.paras_air, R.id.status, R.id.dikemaskini,  R.id.msg});
            lv.setAdapter(adapter);
        }
    }
}


