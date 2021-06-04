package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class food extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    ImageView imghumburger;
ImageView imgKika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

       imghumburger = findViewById(R.id.imghumburger);
        imgKika = findViewById(R.id.imgKika);
        trackScreen("food");
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        imghumburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(food.this,humburger.class);
                startActivity(i);
            }
        });

        imgKika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(food.this,Kika.class);
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