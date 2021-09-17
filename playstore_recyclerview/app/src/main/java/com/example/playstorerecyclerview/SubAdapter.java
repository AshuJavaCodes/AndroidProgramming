package com.example.playstorerecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.viewHolder> {
    Context context;
    ArrayList<Integer> resource;
    ArrayList<String> app_name;

    public SubAdapter(@NonNull Context context, ArrayList<Integer> resource, ArrayList<String> app_name) {

        this.context = context;
        this.resource = resource;
        this.app_name = app_name;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new viewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.unit_view, viewGroup , false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        viewHolder.image_one.setImageResource(resource.get(i));
        viewHolder.app_nametv.setText(app_name.get(i));
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView image_one;
        TextView app_nametv;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image_one = itemView.findViewById(R.id.image_one);
            app_nametv = itemView.findViewById(R.id.appname);

        }
    }
}
