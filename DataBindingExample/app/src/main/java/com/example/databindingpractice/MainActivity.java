package com.example.databindingpractice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.databindingpractice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bindingofMain; //this ActivityMainBinding will be automatically created according to the layout name.
    //create a binding variable.


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        bindingofMain = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bindingofMain.getRoot());
        String chngeTv = "Data Binding Tutorial";
        //ID of elements in the view will be automatically generated.
        bindingofMain.buttonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindingofMain.tvOnexx.setText(chngeTv);
            }
        });

    }
}