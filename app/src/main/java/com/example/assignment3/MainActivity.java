package com.example.assignment3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    RecyclerView r1;
    ArrayList<Log> act = new ArrayList<>();
    ArrayList<Time> time = new ArrayList<>();
    ArrayList<Log> logMsg = new ArrayList<>();
    ArrayList<Time> timeMsg = new ArrayList<>();
    String shareLog, shareTime;

    Button button1, button2;


    MyOwnAdapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

        r1 = findViewById(R.id.myRecyclerView);
        button1 = findViewById(R.id.showInGrid);
        button2 = findViewById(R.id.showInApp);
        act.add( new Log("OnCreate Used"));
        android.util.Log.d("TAG", "onCreate: ");
        time.add(new Time(currentDateTimeString));

        ad = new MyOwnAdapter(this, act,time);
        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("act",act);
                intent.putExtra("time", time);
                android.util.Log.d(TAG, "onClick: ");
                startActivity(intent);


            }
        });


    }





    @Override
    protected void onStart() {
        super.onStart();
        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

        r1 = findViewById(R.id.myRecyclerView);
        act.add( new Log("OnStart Used"));
        time.add(new Time(currentDateTimeString));
        android.util.Log.d("TAG", "onStart: ");

        ad = new MyOwnAdapter(this, act, time);
        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

        r1 = findViewById(R.id.myRecyclerView);
        act.add( new Log("OnRestart Used"));
        time.add(new Time(currentDateTimeString));
        android.util.Log.d(TAG, "onRestart: ");

        ad = new MyOwnAdapter(this, act, time);
        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

        r1 = findViewById(R.id.myRecyclerView);
        act.add( new Log("OnResume Used"));
        time.add(new Time(currentDateTimeString));
        android.util.Log.d(TAG, "onResume: ");

        ad = new MyOwnAdapter(this, act, time);
        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));

        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View v) {

                logMsg = (ArrayList<Log>) act.clone();
                timeMsg = (ArrayList<Time>) time.clone();
                ArrayList<String> last = new ArrayList<>();
                for (int i = 0; i < logMsg.size(); i++) {

                    shareLog = act.get(i).toString();
                    shareTime = time.get(i).toString();
                    last.add(shareLog + "  ");
                    last.add(shareTime+ "\n ");
                }
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,last.toString());
                intent.setType("text/plain");
                android.util.Log.d(TAG, "onClick: Log sharing");
                if (intent.resolveActivity(getPackageManager())!= null){
                    startActivity(intent);
                }






            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

        r1 = findViewById(R.id.myRecyclerView);
        act.add( new Log("OnStop Used"));
        time.add(new Time(currentDateTimeString));


        ad = new MyOwnAdapter(this, act, time);
        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onPause() {
        super.onPause();
        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

        r1 = findViewById(R.id.myRecyclerView);
        act.add( new Log("OnPause Used"));
        time.add(new Time(currentDateTimeString));

        ad = new MyOwnAdapter(this, act, time);
        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

        r1 = findViewById(R.id.myRecyclerView);
        act.add( new Log("OnDestroy Used"));
        time.add(new Time(currentDateTimeString));

        ad = new MyOwnAdapter(this, act, time);
        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));
    }
}

