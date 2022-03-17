package com.example.newyorkapi;

import static com.android.volley.Request.Method.GET;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public TextView status;
    public TextView numRecords;
    public ImageView imageView;
    public EditText country;
    public RecyclerView recyclerView;

    protected static List<Result> results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = findViewById(R.id.status);
        numRecords = findViewById(R.id.numRecords);
        imageView = findViewById(R.id.search);
        country = findViewById(R.id.editTextTextPersonName2);
        recyclerView = findViewById(R.id.recyclerView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getQueue(country.getText().toString());
            }
        });


    }

    public void getQueue(String country){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                Cosas.url + "query="+country+"&api-key=" + Cosas.apiKey,
                null,
                new Response.Listener<JSONObject>(){
                //Listener to receive the JSON response
                @Override
                public void onResponse(JSONObject response) {
                    String status1 = response.optString("status");
                    String num_results = response.optString("num_results");
                    status.setAlpha(1);
                    status.setText("Status: " + status1);
                    numRecords.setText("Num records: " + num_results);
                    JSONArray jsonArray = response.optJSONArray("results");
                    results = Arrays.asList( new GsonBuilder().create().fromJson(jsonArray.toString(), Result[].class));
                    MyAdapter myAdapter = new MyAdapter(results, getApplicationContext());
                    recyclerView.setAdapter(myAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        }
        },new Response.ErrorListener() {
            //Error listener, or null to ignore errors
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(jsonObjectRequest);

    }
}