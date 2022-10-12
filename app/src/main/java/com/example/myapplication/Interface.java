package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Interface extends AppCompatActivity {

    private Button searchButton;
    private EditText searchText;
    public static final String TAG = "MyAppMessage";
    private RequestQueue requestQueue;
    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);

        
        searchText = findViewById(R.id.editText);
        searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String searchTerm = String.valueOf(searchText.getText());
                Log.i(TAG, searchTerm);

                url = "http://avoindata.prh.fi/bis/v1?totalResults=false&maxResults=70&resultsFrom=0&name=" + searchTerm + "&companyRegistrationFrom=2000-02-02";
                retrieveJSON();
                //MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
            }

        });

    }

    private void retrieveJSON() {
        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.i(TAG, url);
                            JSONArray responseItems = (JSONArray) response.getJSONArray("results");
                            for (int i = 0; i < responseItems.length(); i++) {
                                JSONObject obj = responseItems.getJSONObject(i);
                                String A = obj.getString("businessId");
                                String B = obj.getString("name");
                                String C = obj.getString("registrationDate");
                                String D = obj.getString("companyForm");
                                Log.e(TAG,A + " " + B + " " + C + D);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.e(TAG,"Virhe");

                    }

                });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 1, 1.0f));
        requestQueue.add(jsonObjectRequest);
        Log.e(TAG,"Onnistuu");


    }

}






