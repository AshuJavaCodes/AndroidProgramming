package com.example.databindingpracticemaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.databindingpracticemaster.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding bindingMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bindingMain = ActivityMainBinding.inflate(getLayoutInflater(),);
        super.onCreate(savedInstanceState);
        setContentView(bindingMain.getRoot());
        bindingMain.buttonone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindingMain.tvHelloworld.setText("Changed Button one is Clicked !");
            }
        });
        bindingMain.buttontwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindingMain.tvTwo.setText("Changed Button Two is Clicked !");
            }
        });
    }
}