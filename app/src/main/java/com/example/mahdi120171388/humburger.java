package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class humburger extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humburger);
        trackScreen("humburger");
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }
    void trackScreen(String screenName){
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName);
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
    }
}