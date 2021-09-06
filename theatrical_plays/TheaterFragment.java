package com.example.theatrical_plays;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TheaterFragment extends Fragment {

    public TheaterFragment()
    {

    }

    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_theater, container, false);
    }
}