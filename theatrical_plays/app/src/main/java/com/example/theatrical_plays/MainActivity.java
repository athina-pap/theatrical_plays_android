package com.example.theatrical_plays;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.theatrical_plays.Actor.ActorFragment;
import com.example.theatrical_plays.Home.HomeFragment;
import com.example.theatrical_plays.Productions.MovieFragment;
import com.example.theatrical_plays.Venues.TheaterFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        int type = intent.getIntExtra("prod", 0);
        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        if(type == 1) {
            bottomNavigationView.getMenu().getItem(3).setChecked(true);
            bottomNavigationView.setSelectedItemId(R.id.actors);
        }
        if(type == 2) {
            bottomNavigationView.getMenu().getItem(1).setChecked(true);
            bottomNavigationView.setSelectedItemId(R.id.movie);
        }
        if(type == 3) {
            bottomNavigationView.getMenu().getItem(0).setChecked(true);
            bottomNavigationView.setSelectedItemId(R.id.theater);
        }
        else {
            bottomNavigationView.getMenu().getItem(2).setChecked(true);
        }
        getSupportActionBar().setTitle("Theatrical Analytics for Android");
    }

    public BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod= item -> {

        Fragment fragment = null;

        switch (item.getItemId())
        {
            case R.id.movie:
                fragment = new MovieFragment();
                break;
            case R.id.theater:
                fragment = new TheaterFragment();
                break;
            case R.id.home:
                fragment = new HomeFragment();
                break;
            case R.id.actors:
                fragment = new ActorFragment();
                break;
        }

            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment). commit();

        return true;
    };
}