package com.redeyesncode.netclanexplorer.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import com.redeyesncode.netclanexplorer.R;
import com.redeyesncode.netclanexplorer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // This activity can be made in kotlin as well. I am familiar with kotlin code style as well.
    
    
    private ActivityMainBinding binding;
    
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        binding = ActivityMainBinding.inflate(LayoutInflater.from(MainActivity.this));
        
                initClicks();
                
        setContentView(binding.getRoot());
    }

    private void initClicks() {
        binding.ivRefine.setOnClickListener(view -> {
            Intent refineActivityIntent = new Intent(MainActivity.this, RefineActivity.class);
            startActivity(refineActivityIntent);
        });
        binding.ivNav.setOnClickListener(view -> {
            binding.mainDrawerLayout.openDrawer(GravityCompat.START);
        });

    }
}