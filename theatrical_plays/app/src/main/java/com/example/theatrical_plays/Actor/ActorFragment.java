package com.example.theatrical_plays.Actor;

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
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ActorFragment extends Fragment implements ClickListener {


    public static final String TAG = "MYTAG";
    RequestQueue QUEUE;
    String URLHTTP;

    private ArrayList<Actor> mRecyclerViewItems = new ArrayList<>();
    private AdapterActor mAdapter;
    RecyclerView rv;
    Button sortButton;
    LinearLayout expandedActor;
    LinearLayout homeActor;
    RadioGroup radioActor;
    ArrayList<Integer> numbers = new ArrayList<>();


    public static ActorFragment newInstance()
    {
        ActorFragment fragmentActor = new ActorFragment();
        return fragmentActor;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final  View rootView = inflater.inflate(R.layout.fragment_actor,container,false);

        rv = (RecyclerView)rootView.findViewById(R.id.actorview);
        //rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext(),1));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recycle_divider));
        rv.addItemDecoration(dividerItemDecoration);


        QUEUE = Volley.newRequestQueue(getContext());
        URLHTTP = getResources().getString(R.string.urlserver);
        httpGET(URLHTTP);
        setHasOptionsMenu(true);
        homeActor = rootView.findViewById(R.id.actorFragment);


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
                    URLHTTP = "http://195.251.123.174:8080/api/people/search?q=fullName~" + query ;
                    httpGET(URLHTTP);
                    setHasOptionsMenu(true);
                    return true;
                }
                else {
                    mRecyclerViewItems.clear();
                    QUEUE = Volley.newRequestQueue(getContext());
                    URLHTTP = getResources().getString(R.string.urlserver);
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

            for (int i = 20; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String name = jo_inside.getString("fullName");
                String imagUrl = jo_inside.getString("image");
                int id = jo_inside.getInt("id");
                char[] chars = name.toCharArray();
                StringBuilder sb = new StringBuilder();
                for(char c : chars){
                    if(Character.isDigit(c) || c == '$' || c == '"' || c=='.' || c=='(' || c == '*' || c == '@' || c == '~' || c =='['){
                        sb.append(c);
                    }
                }
                if(sb.length() == 0 && name.length() < 30) {
                    Actor actor = new Actor(name, imagUrl, id);
                    mRecyclerViewItems.add(actor);
                }
            }
            mAdapter    = new AdapterActor(mRecyclerViewItems,this);
            rv.setAdapter(mAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }




    //public void clikcData(String datatitle)
    //{
      //  Toast.makeText(getContext(),datatitle, Toast.LENGTH_SHORT).show();
    //}

    @Override
    public void onClickData(String value, String value2, int value3) {
        Intent int_detail = new Intent(getContext(), Activity_bio.class);
        int_detail.putExtra("id",value3);
        int_detail.putExtra("image", value);
        int_detail.putExtra("fullName", value2);
        getActivity().startActivity(int_detail);
    }

    @Override
    public void onClickDataProd(String title, Integer id, String desc) {
        //
    }


}