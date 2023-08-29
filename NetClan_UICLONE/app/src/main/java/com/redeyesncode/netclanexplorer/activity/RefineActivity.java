package com.redeyesncode.netclanexplorer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.redeyesncode.netclanexplorer.R;
import com.redeyesncode.netclanexplorer.databinding.ActivityRefineBinding;

public class RefineActivity extends AppCompatActivity {

    private ActivityRefineBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRefineBinding.inflate(LayoutInflater.from(RefineActivity.this));

        initClicks();

        setContentView(binding.getRoot());
    }

    private void initClicks() {
        binding.ivBack.setOnClickListener(view -> {

            onBackPressed();

        });

    }
}