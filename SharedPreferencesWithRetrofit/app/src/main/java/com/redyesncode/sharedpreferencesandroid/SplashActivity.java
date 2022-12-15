package com.redyesncode.sharedpreferencesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.redyesncode.sharedpreferencesandroid.databinding.ActivityMainBinding;
import com.redyesncode.sharedpreferencesandroid.session.AppSession;
import com.redyesncode.sharedpreferencesandroid.session.Constants;

public class SplashActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        onClickEvents();
        
        checkIfValueIsAlreadyStoredInSession();
        
        
        
    }

    private void checkIfValueIsAlreadyStoredInSession() {
        String valueStored = AppSession.getInstance(SplashActivity.this).getValue(Constants.SAMPLE_KEY_NAME_HERE);
        if(valueStored == null){
            binding.tvStoredValueSP.setText("");

        }else if(valueStored.isEmpty()){
            binding.tvStoredValueSP.setText("");
        }else {
            binding.tvStoredValueSP.setText("Value is already stored in shared preferences.");
        }



    }

    private void onClickEvents() {
        // Write all the setOnClick Listeners here.
        binding.btnStoreSPValue.setOnClickListener(view -> {
            // Here on button click what do we want ?

            // 1. Store the value in the shared pref.
            // 2. Change the text in the upper text view placed in UI.

            // For storing the value in Shared pref. we a need a instance of the
            // Shared pref.

            // ****** For get Instance of SP. ********

            AppSession.getInstance(SplashActivity.this).setValue(Constants.SAMPLE_KEY_NAME_HERE,"Android_Internal_Shared_pref.");
            // Task one is complete.
            
            // Task two.
            binding.tvStoredValueSP.setText("Stored Value in shared preference.");
            



        });



    }
}