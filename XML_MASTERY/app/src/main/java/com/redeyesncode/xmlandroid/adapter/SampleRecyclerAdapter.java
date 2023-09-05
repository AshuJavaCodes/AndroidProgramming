package com.redeyesncode.xmlandroid.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SampleRecyclerAdapter extends RecyclerView.Adapter<SampleRecyclerAdapter.MyViewholder> {


    ArrayList<String> dataSet = new ArrayList<>();
    public SampleRecyclerAdapter(ArrayList<String> dataSets) {
        this.dataSet = dataSets;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder{

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            // Linking of view binding with the layout file goes here.

        }
    }

}
