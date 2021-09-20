package com.example.tabs_and_fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class tabAdapter extends FragmentPagerAdapter  {
    int tabCount;

    public tabAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                tab1fragment tab1 = new tab1fragment();
                return tab1;
            case 1:
                frg_tab2 tab2 = new frg_tab2();
                return tab2;
        }
        return null;
    }

    /*public tabAdapter(@NonNull FragmentManager fm, int behavior, int tabCount) {
        super(fm, behavior);
        this.tabCount = tabCount;
    }*/

    @Override
    public int getCount() {
        return tabCount;
    }
}
