package com.example.theatrical_plays.Productions;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.theatrical_plays.R;
import com.example.theatrical_plays.formaterLabel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ProductionActivity extends AppCompatActivity {
    private TextView lowerPrice;
    private TextView higherPrice;
    private BarChart allEvents;
    RequestQueue QUEUE;
    String URLHTTP;
    ArrayList<Integer> eventsnumber = new ArrayList<>();
    ArrayList<Events> events = new ArrayList<>();
    ArrayList<Production> productions = new ArrayList<>();
    int y = 0;
    String prodTitle;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList<BarEntry> barEntriesArrayList =  new ArrayList<>();
    ArrayList<String> labels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production);
        Intent intent = getIntent();
        lowerPrice = findViewById(R.id.cheapestticket);
        higherPrice = findViewById(R.id.expensiveticket);
        allEvents = findViewById(R.id.eventChart);
        productions = (ArrayList<Production>) intent
               .getSerializableExtra("productions");

        for (int i= 0; i<productions.size(); i ++) {
            QUEUE = Volley.newRequestQueue(this);
            labels.add(productions.get(i).getTitle());
            URLHTTP = "http://laptop-t6ir0pds:8080/api/productions/" + productions.get(i).getId() + "/events";
            httpGET(URLHTTP);

        }
        
    }
    public void Cheapest() {
        double min = 100;
        String prod = null;
        String venue = null;
        for(int i = 0; i<events.size(); i++)
        {
            double pricerange = FormatPrice(events.get(i).getPriceRange());

            if(pricerange < min)
            {
                min = pricerange;
                prod = events.get(i).getTitle();
                venue = events.get(i).getVenueName();
            }
        }
        lowerPrice.setText("η παραγωγή " + prod + " στο Θέατρο " + venue + " με τιμή " + min);
    }
    public void Higher() {
        double max = 1;
        String prod = null;
        String venue = null;
        for(int i = 0; i<events.size(); i++)
        {
            double pricerange = FormatPrice(events.get(i).getPriceRange());

            if(pricerange > max)
            {
                max = pricerange;
                prod = events.get(i).getTitle();
                venue = events.get(i).getVenueName();
            }
        }
        higherPrice.setText("η παραγωγή " + prod + " στο Θέατρο " + venue + " με τιμή " + max);
    }
    private  void setUpBarChart()
    {
        if(barEntriesArrayList.size() > 0) {
            barDataSet = new BarDataSet(barEntriesArrayList, "eventNumber");
            barData = new BarData(barDataSet);
            allEvents.setData(barData);
            barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
            barDataSet.setValueTextColor(Color.BLACK);
            barDataSet.setValueTextSize(16f);
            Description description = new Description();
            description.setText("Events");
            allEvents.setDescription(description);
            allEvents.animateY(1000);
            allEvents.invalidate();
            //set XAxis formater
            XAxis xAxis = allEvents.getXAxis();
            xAxis.setLabelCount(labels.size());
            xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
            //xAxis.setValueFormatter(new formaterLabel(labels));
            xAxis.setGranularity(1f);
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setDrawGridLines(false);
            xAxis.setGranularityEnabled(true);
            xAxis.setDrawAxisLine(false);
            xAxis.setLabelRotationAngle(35);


        }
    }
    public double FormatPrice(String priceRange){
        priceRange = priceRange.replaceAll("από", "");
        String[] newPrice =  priceRange.split("-");
        double price;
        if(newPrice.length == 1)
        {
            StringBuffer sb = new StringBuffer(priceRange);
            sb.deleteCharAt(sb.length()-1);
            String[] p =  String.valueOf(sb).split(",");
            price = Double.parseDouble(p[0]);
        }
        else
        {
            StringBuffer sb = new StringBuffer(newPrice[1]);
            sb.deleteCharAt(sb.length()-1);
            String[] p =  String.valueOf(sb).split(",");
            price = Double.parseDouble(p[0]);


        }
        return price;
    }
    private  void getBarEntries(ArrayList<Integer> eventsnumber, ArrayList<Events> events)
    {
        for (int i = 0; i < eventsnumber.size(); i++) {
            int numberEvents = eventsnumber.get(i);
            barEntriesArrayList.add(new BarEntry(i , numberEvents));
        }
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
            //JSONObject m_obj = obj.getJSONObject("data");
            JSONArray m_jArry = obj.getJSONArray("data");
            eventsnumber.add(y,m_jArry.length());
            prodTitle = productions.get(y).getTitle();
            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String priceRange = jo_inside.getString("priceRange");
                String title = jo_inside.getString("title");
                int id = jo_inside.getInt("eventId");

                Events e = new Events(id, priceRange, prodTitle,"", title);
                events.add(e);

            }

            y++;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(y == productions.size()) {

            Cheapest();
            Higher();
            getBarEntries(eventsnumber, events);
            setUpBarChart();
        }
    }
}
