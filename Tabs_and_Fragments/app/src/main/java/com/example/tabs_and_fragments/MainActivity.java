package com.example.tabs_and_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.tabs_and_fragments.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager vpager;
    TabLayout tabLayout1;
    TabItem tbone1, tbtwo2;
    ViewPager v2pager;

    //ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vpager = findViewById(R.id.vpager);
        tabLayout1 = findViewById(R.id.tab_layout);

        //THROWS ERROR WITH VIEW BINDING. AND DOES NOT THROW ERROR WITH FIND_VIEW_BY_ID. WHY??

        /*v2pager = mainBinding.vpager;
        tbone1 = mainBinding.tbone;
        tbtwo2 = mainBinding.tbtwo;
        tabLayout1 = mainBinding.tabLayout;*/


        tabAdapter tabAdapterx = new tabAdapter(getSupportFragmentManager(),tabLayout1.getTabCount());
        vpager.setAdapter(tabAdapterx);
        vpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));
        tabLayout1.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}