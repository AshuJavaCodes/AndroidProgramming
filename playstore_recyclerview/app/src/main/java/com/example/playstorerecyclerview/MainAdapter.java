package com.example.playstorerecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {

    ArrayList<Integer> type_one = new ArrayList<>();
    ArrayList<Integer> type_two = new ArrayList<>();
    ArrayList<Integer> type_three = new ArrayList<>();
    ArrayList<String> app_nameone = new ArrayList<>();
    ArrayList<String> app_nametwo = new ArrayList<>();
    ArrayList<String> app_namethree = new ArrayList<>();

    Context context;


    public MainAdapter(@NonNull Context context) {
        //Defining the fisrt Row of recyclerView
            type_one.add(R.drawable.play_splash);
        type_one.add(R.drawable.minecraft);
        type_one.add(R.drawable.soundcloud);
        type_one.add(R.drawable.snapchat);
        //
        app_nameone.add("PlayStore");
        app_nameone.add("MineCraft");
        app_nameone.add("SoundCloud");
        app_nameone.add("Snapchat");
        app_nameone.add("Whatsapp");

        app_namethree.add("Paytm");
        app_namethree.add("Spotify");
        app_namethree.add("SoundCloud");
        app_namethree.add("Facebook");


        app_nametwo.add("Google Maps");
        app_nametwo.add("Office App");
        app_nametwo.add("Laptop Repair");
        app_nametwo.add("MakeMyTrip");

        //DefiningSecondRowOfRecyclerView
        type_two.add(R.drawable.ic_baseline_location_on_24);
        type_two.add(R.drawable.ic_baseline_home_repair_service_24);
        type_two.add(R.drawable.ic_baseline_laptop_24);
        type_two.add(R.drawable.ic_baseline_landscape_24);
        type_two.add(R.drawable.ic_baseline_insert_emoticon_24);

        type_three.add(R.drawable.ic_baseline_how_to_reg_24);
        type_three.add(R.drawable.ic_baseline_grass_24);
        type_three.add(R.drawable.ic_baseline_gps_not_fixed_24);
        type_three.add(R.drawable.ic_baseline_forward_to_inbox_24);




        this.context = context;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new viewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.unit_main,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
       if(i%4==0){ //firstRow
           viewHolder.app_section.setText("Recommeded For you");
           viewHolder.sub_title.setText("Curated just for you");
           viewHolder.recyclerView.setAdapter(new SubAdapter(context, type_one, app_nameone));
       }else if(i%4==1){ //SecondRow
           viewHolder.app_section.setText("Premium Apps");
           viewHolder.sub_title.setText("Play Along");
           viewHolder.recyclerView.setAdapter(new SubAdapter(context, type_two, app_nametwo));
       }else if(i%4 == 2){ //ThirdRow
           viewHolder.app_section.setText("New And Updated Games");
           viewHolder.sub_title.setText("New in the Market");
           viewHolder.recyclerView.setAdapter(new SubAdapter(context, type_three, app_namethree));
       }else if(i%4 == 3){ //FourthRow
           viewHolder.app_section.setText("Pre-registration Section");
           viewHolder.sub_title.setText("Pre Order Now.");
           viewHolder.recyclerView.setAdapter(new SubAdapter(context, type_one, app_nameone));
       }

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        TextView app_section, sub_title;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.sub_recyclerviews);
            app_section = itemView.findViewById(R.id.appsection);
            sub_title = itemView.findViewById(R.id.subitle);

        }
    }

}
