package com.example.theatrical_plays.Venues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.theatrical_plays.Actor.Bio;
import com.example.theatrical_plays.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class VenueCompare extends AppCompatActivity {
    private PieChart pieChart;
    RequestQueue QUEUE;
    String URLHTTP;
    ArrayList<Integer> productionNumber = new ArrayList<>();
    ArrayList<Venue> venues = new ArrayList<>();
    int y = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_compare);
        Intent intent = getIntent();
        pieChart = findViewById(R.id.ProductionsChart);
        venues = (ArrayList<Venue>) intent
                .getSerializableExtra("venues");
        for (int i= 0; i<venues.size(); i ++) {
            QUEUE = Volley.newRequestQueue(this);
            URLHTTP = "http://83.212.111.242:8080/api/venues/" + venues.get(i).getId() + "/productions";
            httpGET(URLHTTP);
        }
    }
    private void setupPieChart(){
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setEntryLabelColor(Color.WHITE);
        pieChart.setCenterText("Productions By Venues");
        pieChart.setCenterTextSize(20);
        pieChart.getDescription().setEnabled(false);
        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);

    }
    private void loadPieChart(ArrayList<Integer> productionNumber, ArrayList<Venue> venues)
    {
        int sum = 0;
        for (int i =0; i< productionNumber.size(); i++)
        {
            sum = sum + productionNumber.get(i);
        }
        ArrayList<PieEntry> entries = new ArrayList<>();
        if(sum != 0 ) {
            for (int i = 0; i < venues.size(); i++) {

                double percent = productionNumber.get(i) * 100 / sum;
                entries.add(new PieEntry((float) percent, venues.get(i).getTitle()));
            }
        }
        ArrayList<Integer> colors = new ArrayList<>();
        for (int color: ColorTemplate.MATERIAL_COLORS)
        {
            colors.add(color);
        }
        for (int color: ColorTemplate.VORDIPLOM_COLORS)
        {
            colors.add(color);
        }
        PieDataSet dataSet = new PieDataSet(entries,"Venues");
        dataSet.setColors(colors);
        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.WHITE);
        pieChart.setData(data);
        pieChart.invalidate();

        pieChart.animateY(1400, Easing.EaseInOutQuad);
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
            productionNumber.add(y, m_jArry.length());

            y++;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(y == venues.size()) {

            loadPieChart(productionNumber, venues);
            setupPieChart();
        }
    }
}