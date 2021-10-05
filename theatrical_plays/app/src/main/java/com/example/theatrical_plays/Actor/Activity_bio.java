package com.example.theatrical_plays.Actor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.theatrical_plays.R;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class Activity_bio extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Object> viewItems = new ArrayList<>();
    private Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    RequestQueue QUEUE;
    String URLHTTP;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        mRecyclerView = (RecyclerView)findViewById(R.id.roles);
        mRecyclerView.setHasFixedSize(true);


        ImageView imageView = findViewById(R.id.bioImage);

        TextView textView = findViewById(R.id.bioName);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("image");
        Picasso.get().load(imageUrl).fit().centerInside().into(imageView);
        String name = intent.getStringExtra("fullName");
        int id = intent.getIntExtra("id",0);
        textView.setText(name);
        mAdapter    = new Adapter(viewItems,this);
        QUEUE = Volley.newRequestQueue(this);
        URLHTTP = "http://LAPTOP-T6IR0PDS:8080/api/people/"+id+"/productions";
        httpGET(URLHTTP);

        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new Adapter(viewItems,this);
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

    public void parsingData(String jsonData)
    {
        try {
            JSONObject obj = new JSONObject(jsonData);
            JSONObject m_obj = obj.getJSONObject("data");
            JSONArray m_jArry = m_obj.getJSONArray("content");

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String role = jo_inside.getString("role");
                String title = jo_inside.getString("title");

                Bio bio= new Bio(role,title);
                viewItems.add(bio);

            }
            mRecyclerView.setAdapter(mAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}