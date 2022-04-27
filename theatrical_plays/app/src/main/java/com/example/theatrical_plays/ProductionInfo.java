package com.example.theatrical_plays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.theatrical_plays.Actor.Adapter;
import com.example.theatrical_plays.R;

import java.util.ArrayList;
import java.util.List;

public class ProductionInfo extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_info);
        TextView textView = findViewById(R.id.title_prod);
        TextView description = findViewById(R.id.description_prod);
        TextView producer = findViewById(R.id.producer);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String Desc = intent.getStringExtra("desc");
        String prod = intent.getStringExtra("producer");
        textView.setText(title);
        description.setText(Desc);
        producer.setText(prod);
    }
}