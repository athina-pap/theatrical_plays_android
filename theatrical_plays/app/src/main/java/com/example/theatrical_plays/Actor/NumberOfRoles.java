package com.example.theatrical_plays.Actor;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

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

public class NumberOfRoles {

    RequestQueue QUEUE;
    private String Url;
    public int number;
    Context context;

    public NumberOfRoles(String url,  Context context) {
        Url = url;
        QUEUE = Volley.newRequestQueue(context);
        //httpGET(Url);
    }


}
