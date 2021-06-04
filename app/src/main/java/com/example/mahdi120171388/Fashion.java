package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class Fashion extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    ImageView imgshit;
    ImageView imgshoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion);
        trackScreen("Fashion");
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        imgshit = findViewById(R.id.imgshit);
        imgshoes = findViewById(R.id.imgshoes);


        imgshit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Fashion.this,Shirt.class);
                startActivity(i);
            }
        });

        imgshoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Fashion.this,shoes.class);
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