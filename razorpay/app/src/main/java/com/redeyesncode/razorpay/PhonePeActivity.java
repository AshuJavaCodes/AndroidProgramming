package com.redeyesncode.razorpay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.redeyesncode.razorpay.databinding.ActivityPhonePeBinding;

public class PhonePeActivity extends AppCompatActivity {

    private ActivityPhonePeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhonePeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}