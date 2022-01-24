package com.example.assignment3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    final static public String TAG = "TAG";
    GridView gridView;
    ArrayList<Log> activities;
    ArrayList<Time> timestamps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
        gridView = findViewById(R.id.myGridLIst);

        android.util.Log.d(TAG, "onCreate: Log is being shared to another activity ");

        activities = (ArrayList<Log>) getIntent().getSerializableExtra("act");
        timestamps = (ArrayList<Time>) getIntent().getSerializableExtra("time");
        GridAdapter gridAdapter = new GridAdapter(SecondActivity.this, activities, timestamps);
        gridView.setAdapter(gridAdapter);
        android.util.Log.d(TAG, "onCreate: Log printed in grid view ");


    }



}