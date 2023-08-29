package com.redeyesncode.netclanexplorer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.redeyesncode.netclanexplorer.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Using handler to move to next activity automatically.


        boolean handler = new Handler().postDelayed(() -> {
            Intent dashboardActivityMain = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(dashboardActivityMain);
        },1500);



    }
}