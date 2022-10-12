package com.example.theatrical_plays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.theatrical_plays.Actor.Adapter;
import com.example.theatrical_plays.Actor.AdapterActor;
import com.example.theatrical_plays.Actor.Bio;
import com.example.theatrical_plays.Productions.Events;
import com.example.theatrical_plays.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ProductionInfo extends AppCompatActivity {

    RequestQueue QUEUE;
    String URLHTTP;
    private RecyclerView mRecyclerView;
    private List<Events> eventsList = new ArrayList<>();
    private AdapterEvent mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_info);
        TextView textView = findViewById(R.id.title_prod);
        TextView description = findViewById(R.id.description_prod);
        TextView producer = findViewById(R.id.Producer);
        Intent intent = getIntent();
        mRecyclerView = findViewById(R.id.events_production);
        String title = intent.getStringExtra("title");
        String Desc = intent.getStringExtra("desc");
        String prod = intent.getStringExtra("producer");
        String url = intent.getStringExtra("url");
        String url1 = intent.getStringExtra("url1");
        int id = intent.getIntExtra("id", 0);
        textView.setText(title);
        description.setText(Desc);
        String prod1 = prod.replaceAll("\\s+ ", " ");
        prod.replace("\r\n", "");
        producer.setText(prod1);
        ImageView imageProd = findViewById(R.id.image_default);
        if(url1 != null)
        {Picasso.get().load(url1).placeholder(R.drawable.ic_actor).into(imageProd);}
        else
        {Picasso.get().load(url).placeholder(R.drawable.ic_actor).into(imageProd);}
        mAdapter    = new AdapterEvent(eventsList,this);
        QUEUE = Volley.newRequestQueue(this);
        URLHTTP = "http://195.251.123.174:8080/api/productions/"+id+"/events";
        httpGET(URLHTTP);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        Button trailer = findViewById(R.id.trailer_button);
        trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(url);
                Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent1);
            }
        });
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

    public void parsingData(String jsonData)
    {
        try {
            JSONObject obj = new JSONObject(jsonData);
            JSONArray m_jArry = obj.getJSONArray("data");
                for (int i = 0; i < m_jArry.length(); i++) {
                    JSONObject jo_inside = m_jArry.getJSONObject(i);
                    Integer id = jo_inside.getInt("eventId");
                    String priceRange = jo_inside.getString("priceRange");
                    String title = jo_inside.getString("title");
                    String address = jo_inside.getString("address");
                    Events events = new Events(id, priceRange, title, address, "");
                    eventsList.add(events);
                }
                mAdapter    = new AdapterEvent(eventsList,this);
                mRecyclerView.setAdapter(mAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}