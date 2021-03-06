package com.example.theatrical_plays.Productions;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.theatrical_plays.Actor.Actor;
import com.example.theatrical_plays.Actor.AdapterActor;
import com.example.theatrical_plays.R;
import com.example.theatrical_plays.Venues.Venue;
import com.example.theatrical_plays.Venues.VenueCompare;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class MovieFragment extends Fragment {
    public static final String TAG = "MYTAG";
    private List<Production> mRecyclerViewItems = new ArrayList<>();
    private AdapterProduction mAdapter;
    RecyclerView rv;
    RequestQueue QUEUE;
    String URLHTTP;
    public MovieFragment newInstance() {
        MovieFragment movieFragment = new MovieFragment();
        return movieFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final  View rootView =  inflater.inflate(R.layout.fragment_movie, container, false);
        rv = (RecyclerView)rootView.findViewById(R.id.productions);
        //rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext(),1));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recycle_divider));
        rv.addItemDecoration(dividerItemDecoration);


        mAdapter    = new AdapterProduction(mRecyclerViewItems, getContext());
        QUEUE = Volley.newRequestQueue(getContext());
        URLHTTP = getResources().getString(R.string.productions);
        httpGET(URLHTTP);
        setHasOptionsMenu(true);
        return rootView;
    }



    private void httpGET(String url) {
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
                    Log.d(TAG,"ERROR "+responseBody);
                }catch (UnsupportedEncodingException errorr){
                    Log.d(TAG,errorr.toString());
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
                String title = jo_inside.getString("title");
                String duration = jo_inside.getString("duration");
                int id = jo_inside.getInt("id");

                Production production= new Production(title, duration, id);
                mRecyclerViewItems.add(production);

            }

            rv.setAdapter(mAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}

