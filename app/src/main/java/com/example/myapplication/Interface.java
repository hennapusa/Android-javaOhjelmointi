package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;


public class Interface extends AppCompatActivity {

    private Button searchButton;
    private EditText searchText;
    public static final String TAG = "MyAppMessage";
    private RequestQueue requestQueue;
    private String url;
    private RecycleAdapter adapter;
    private RecyclerView recyclerView;
  TextView errorText;

    private ArrayList<Company> companies = new ArrayList<Company>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);

        recyclerView = (RecyclerView) findViewById(R.id.cardList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        errorText = findViewById(R.id.errorText);

        searchText = findViewById(R.id.editText);
        searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                findViewById((R.id.loader)).setVisibility(View.VISIBLE);
                //findViewById((R.id.errorText)).setVisibility(View.GONE);

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
                            companies = new ArrayList<Company>();
                            JSONArray responseItems = (JSONArray) response.getJSONArray("results");
                            for (int i = 0; i < responseItems.length(); i++) {
                                Company currentCompany = new Company();

                                JSONObject obj = responseItems.getJSONObject(i);
                                String A = obj.getString("businessId");
                                String B = obj.getString("name");
                                String C = obj.getString("registrationDate");
                                String D = obj.getString("companyForm");
                                currentCompany.setBusinessId(A);
                                currentCompany.setName(B);
                                currentCompany.setRegistrationDate(C);
                                currentCompany.setCompanyForm(D);

                                Log.e(TAG, A + " " + B + " " + C + D);
                                companies.add(currentCompany);
                                // adapter = new RecycleAdapter(companies);
                                // RecyclerView.setAdapter(adapter);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        setupView();


                    }


                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.e(TAG, "Tuleeko virhe");
                        recyclerView.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.INVISIBLE);
                        errorText.setText("No result");
                        findViewById(R.id.loader).setVisibility(View.GONE);


                    }


                });

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(10 * 1000, 1, 1.0f));
        requestQueue.add(jsonObjectRequest);
        Log.e(TAG, "Onnistuuko");


    }

    private void setupView() {


        adapter = new RecycleAdapter(companies);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        findViewById(R.id.loader).setVisibility(View.GONE);


    }
}








