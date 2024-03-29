package com.example.theatrical_plays.Productions;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.theatrical_plays.R;
import com.google.android.material.slider.Slider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class MovieFragment extends Fragment {
    public static final String TAG = "MYTAG";
    private List<Production> mRecyclerViewItems = new ArrayList<>();
    private ArrayList<Production> checkedProductionsCopy = new ArrayList<>();
    private AdapterProduction mAdapter;
    RecyclerView rv;
    RequestQueue QUEUE;
    String URLHTTP;
    Button filters;
    LinearLayout expandedView;
    RelativeLayout home;
    Button applyFilters;
    Button clear;
    Slider duration;
    CheckBox latest;
    Boolean already = true;

    public MovieFragment newInstance() {
        MovieFragment movieFragment = new MovieFragment();
        return movieFragment;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
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
        QUEUE = Volley.newRequestQueue(getContext());
        URLHTTP = getResources().getString(R.string.productions);
        httpGET(URLHTTP);
        setHasOptionsMenu(true);
        expandedView = rootView.findViewById(R.id.expandedView);
        filters = rootView.findViewById(R.id.filtersButton);
        home = rootView.findViewById(R.id.home);
        filters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandedView.getVisibility() == v.GONE)
                {
                    TransitionManager.beginDelayedTransition(home, new AutoTransition());
                    expandedView.setVisibility(v.VISIBLE);
                }else
                {
                    TransitionManager.beginDelayedTransition(home, new AutoTransition());
                    expandedView.setVisibility(v.GONE);
                }
            }
        });
        applyFilters = rootView.findViewById(R.id.applyFilters);
        duration = rootView.findViewById(R.id.duration);
        latest = rootView.findViewById(R.id.latest);
        applyFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int appliedDur = (int)duration.getValue();
                if(latest.isChecked() && already) {
                    already = false;
                    mRecyclerViewItems.clear();
                    QUEUE = Volley.newRequestQueue(getContext());
                    URLHTTP = "http://195.251.123.174:8080/api/productions/latest";
                    httpGET(URLHTTP);
                    setHasOptionsMenu(true);

                }
                if(appliedDur < 300) {
                    mAdapter.getFilter().filter(String.valueOf(appliedDur));
                }


            }

        });

        clear = rootView.findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duration.setValue(300);
                int appliedDur = (int)duration.getValue();
                latest.setChecked(false);
                mRecyclerViewItems.clear();
                QUEUE = Volley.newRequestQueue(getContext());
                URLHTTP = "http://195.251.123.174:8080/api/productions";
                httpGET(URLHTTP);
                setHasOptionsMenu(true);
                already = true;

            }
        });
        Button compareProd = rootView.findViewById(R.id.compare_production);
        compareProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(Production x:mAdapter.productionsClicked )
                {
                    checkedProductionsCopy.add(x);
                }
                if(checkedProductionsCopy != null) {
                    Intent intent = new Intent(getContext(), ProductionActivity.class);
                    intent.putExtra("productions", checkedProductionsCopy);
                    getActivity().startActivity(intent);
                    checkedProductionsCopy.clear();
                }
            }
        });

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query != null) {
                    mRecyclerViewItems.clear();
                    QUEUE = Volley.newRequestQueue(getContext());
                    URLHTTP = "http://195.251.123.174:8080/api/productions/search?q=title~" + query ;
                    httpGET(URLHTTP);
                    setHasOptionsMenu(true);
                    return true;
                }
                else {
                    mRecyclerViewItems.clear();
                    QUEUE = Volley.newRequestQueue(getContext());
                    URLHTTP = getResources().getString(R.string.productions);
                    httpGET(URLHTTP);
                    setHasOptionsMenu(true);
                    return true;
                }
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        super.onCreateOptionsMenu(menu,inflater);
    }

    private void httpGET(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        if(mAdapter != null) {
                            if (mAdapter.productionsClicked.size() > 0) {
                                checkedProductionsCopy.addAll(mAdapter.productionsClicked);
                            }
                        }
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
                String producer = jo_inside.getString("producer");
                String description = jo_inside.getString("description");
                int id = jo_inside.getInt("id");
                String url = jo_inside.getString("mediaURL");

                Production production= new Production(title, duration, description, producer, id, false, url);
                mRecyclerViewItems.add(production);

            }

            mAdapter    = new AdapterProduction(mRecyclerViewItems,getContext(),latest.isChecked());
            rv.setAdapter(mAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

