package com.example.theatrical_plays.Venues;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.theatrical_plays.AdapterEvent;
import com.example.theatrical_plays.Productions.Events;
import com.example.theatrical_plays.Productions.Production;
import com.example.theatrical_plays.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TheatersInfo extends AppCompatActivity {
    RequestQueue QUEUE;
    String URLHTTP;
    private RecyclerView mRecyclerView;
    private List<Production> productionList = new ArrayList<>();
    private AdapterVenueInfo mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theaters_info);

        TextView textView = findViewById(R.id.title_venue);
        TextView address = findViewById(R.id.addressInfo);
        Intent intent = getIntent();
        mRecyclerView = findViewById(R.id.production_per_theater);
        String addressIntent = intent.getStringExtra("address");
        String title = intent.getStringExtra("title");
        int id = intent.getIntExtra("id", 0);
        textView.setText(title);
        address.setText(addressIntent);
        mAdapter    = new AdapterVenueInfo(productionList,this);
        QUEUE = Volley.newRequestQueue(this);
        URLHTTP = "http://192.168.1.3:8080/api/venues/"+id+"/productions";
        httpGET(URLHTTP);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
    public void httpGET(String url)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parsingData(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    String responseBody = new String(error.networkResponse.data,"utf-8");
                    Log.d("tag","ERROR "+responseBody);
                }catch (UnsupportedEncodingException errorr){
                    Log.d("tag",errorr.toString());
                }
            }
        }
        );
        QUEUE.add(stringRequest);
    }

    private void parsingData(String jsonData)
    {
        try {
            JSONObject obj = new JSONObject(jsonData);
            JSONObject m_obj = obj.getJSONObject("data");
            JSONArray m_jArry = m_obj.getJSONArray("content");
            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String title = jo_inside.getString("title");
                String duration = jo_inside.getString("duration");
                String producer = jo_inside.getString("producer");
                String description = jo_inside.getString("description");
                int id = jo_inside.getInt("id");
                String url = jo_inside.getString("mediaURL");

                Production production= new Production(title, duration, description, producer, id, false, url);
                productionList.add(production);
            }
            mAdapter    = new AdapterVenueInfo(productionList,this);
            mRecyclerView.setAdapter(mAdapter);



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}