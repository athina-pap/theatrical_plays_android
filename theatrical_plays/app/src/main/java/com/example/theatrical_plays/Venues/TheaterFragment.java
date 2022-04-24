package com.example.theatrical_plays.Venues;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
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
import com.example.theatrical_plays.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class TheaterFragment extends Fragment{
    public static final String TAG = "MYTAG";
    RequestQueue QUEUE;
    String URLHTTP;
    private List<Venue> mRecyclerViewItems = new ArrayList<>();
    private AdapterVenue mAdapter;
    RecyclerView rv;

    public TheaterFragment newInstance()
    {
        TheaterFragment fragmentTheater = new TheaterFragment();
        return fragmentTheater;
    }


    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState)
    {
        final  View rootView = inflater.inflate(R.layout.fragment_theater,container,false);

        rv = (RecyclerView)rootView.findViewById(R.id.theaterView);
        //rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext(),1));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recycle_divider));
        rv.addItemDecoration(dividerItemDecoration);


        mAdapter    = new AdapterVenue(mRecyclerViewItems, getContext());
        QUEUE = Volley.newRequestQueue(getContext());
        URLHTTP = getResources().getString(R.string.venues);
        httpGET(URLHTTP);
        setHasOptionsMenu(true);
        Button compare = (Button)rootView.findViewById(R.id.compare);
        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAdapter.venuesClicked != null) {
                    Intent int_detail = new Intent(getContext(), VenueCompare.class);
                    int_detail.putExtra("venues", mAdapter.venuesClicked);
                    getActivity().startActivity(int_detail);
                }
            }
        });
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
                String address = jo_inside.getString("address");
                int id = jo_inside.getInt("id");
                Venue venue= new Venue(id, address, title, false);
                mRecyclerViewItems.add(venue);

            }

            rv.setAdapter(mAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}