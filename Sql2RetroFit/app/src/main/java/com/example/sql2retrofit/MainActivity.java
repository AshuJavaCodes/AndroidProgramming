package com.example.sql2retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MySql_To_RetroFit_To_recylerView.
        //Intialize Recview.
        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        processData();
    }
    public void processData()
    {
        Call<List<ResponseModelOneField>> call = api_controller.getInstance().getApiSet().getData();
        call.enqueue(new Callback<List<ResponseModelOneField>>() {
            @Override
            public void onResponse(Call<List<ResponseModelOneField>> call, Response<List<ResponseModelOneField>> response) {
                List<ResponseModelOneField> data = response.body();
                //Returning all methods of the ResponseModel. example getData();
                adapterOne adapterx = new adapterOne()
            }

            @Override
            public void onFailure(Call<List<ResponseModelOneField>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
            }
        });


    }
}