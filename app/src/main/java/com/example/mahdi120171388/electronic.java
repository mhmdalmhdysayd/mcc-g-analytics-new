package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class electronic extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    ImageView imghours;
    ImageView imglaptop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronic);
        trackScreen("electronic");
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        imghours =findViewById(R.id.imghours);
        imglaptop = findViewById(R.id.imglaptop);


        imghours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(electronic.this,hours.class);
                startActivity(i);
            }
        });
        imglaptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(electronic.this,laptop.class);
                startActivity(i);
            }
        });

    }
    void trackScreen(String screenName){
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName);
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
    }

}