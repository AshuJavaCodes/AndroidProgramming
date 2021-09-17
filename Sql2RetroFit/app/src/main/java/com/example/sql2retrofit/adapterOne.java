package com.example.sql2retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapterOne extends RecyclerView.Adapter<adapterOne.myViewHolder>
{

    List<ResponseModelOneField> data;

    public adapterOne(List<ResponseModelOneField> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //INFLATE THE SINGLE ROW XML. ONCREATE ALWAYS RETURN A VIEW. in recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        //ReturnType myView
        return new myViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        //ITERATE_THROUGHT OBJECTS IN LIST OF RESPONSE MODEL.
        holder.username.setText(data.get(position).getUser());
        holder.email.setText(data.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView username,email;
        ImageView img;

        public myViewHolder(@NonNull View itemView, TextView username, TextView email, ImageView img) {
            super(itemView);
            this.username = username;
            this.email = email;
            this.img = img;
            username = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);
            img = itemView.findViewById(R.id.img1);
        }
    }

}
