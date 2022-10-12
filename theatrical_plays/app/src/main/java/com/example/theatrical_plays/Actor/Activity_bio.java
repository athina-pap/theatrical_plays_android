package com.example.theatrical_plays.Actor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.theatrical_plays.ProductionInfo;
import com.example.theatrical_plays.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Activity_bio extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private List<Object> viewItems = new ArrayList<>();
    private List<SlideModel> ImagesList = new ArrayList<>();
    private Adapter mAdapter;
    private ImageSlider images;
    private RecyclerView.LayoutManager layoutManager;
    RequestQueue QUEUE;
    String URLHTTP;
    String numberOfRoles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        mRecyclerView = (RecyclerView)findViewById(R.id.roles);

        images = findViewById(R.id.bioImage);

        TextView textView = findViewById(R.id.bioName);
        Intent intent = getIntent();
        String name = intent.getStringExtra("fullName");
        int id = intent.getIntExtra("id",0);
        textView.setText(name);

        mAdapter    = new Adapter(viewItems,this);
        QUEUE = Volley.newRequestQueue(this);
        URLHTTP = "http://195.251.123.174:8080/api/people/"+id+"/productions";
        httpGET(URLHTTP, "productions");
        QUEUE = Volley.newRequestQueue(this);
        URLHTTP = "http://195.251.123.174:8080/api/people/"+id+"/photos";
        httpGET(URLHTTP, "images");
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void httpGET(String url, String type)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parsingData(response, type);
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

    public void parsingData(String jsonData, String type)
    {
        try {
            JSONObject obj = new JSONObject(jsonData);


            if(type == "productions") {
                JSONObject m_obj = obj.getJSONObject("data");
                JSONArray m_jArry = m_obj.getJSONArray("content");
                for (int i = 0; i < m_jArry.length(); i++) {
                    JSONObject jo_inside = m_jArry.getJSONObject(i);
                    String role = jo_inside.getString("role");
                    Integer id = jo_inside.getInt("productionId");
                    String title = jo_inside.getString("title");
                    String description = jo_inside.getString("description");
                    String producer = jo_inside.getString("producer");
                    String url = jo_inside.getString("mediaURL");

                    Bio bio = new Bio(role, title, id, description, producer, url);
                    viewItems.add(bio);
                }
                numberOfRoles = String.valueOf(m_jArry.length());
                TextView roles= findViewById(R.id.Numrole);
                roles.setText(numberOfRoles);
                mRecyclerView.setAdapter(mAdapter);
            }
            else {
                JSONArray m_jArry = obj.getJSONArray("data");
                for (int i = 0; i < m_jArry.length(); i++) {
                    JSONObject jo_inside = m_jArry.getJSONObject(i);
                    String imageURL = jo_inside.getString("imageURL");
                    ImagesList.add(new SlideModel(imageURL, null));
                }
                if(ImagesList.size()> 0) {
                    images.setImageList(ImagesList);
                }
                else {
                    ImagesList.add(new SlideModel(R.drawable.actor1, null));
                    ImagesList.add(new SlideModel(R.drawable.actor2, null));
                    ImagesList.add(new SlideModel(R.drawable.movie, null));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}