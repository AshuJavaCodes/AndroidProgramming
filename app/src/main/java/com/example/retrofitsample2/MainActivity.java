package com.example.retrofitsample2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText edt_username;
    private EditText edt_password;
    private Button btn_post;
    private TextView tv_result;
    private TextView tv_result2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_password);
        btn_post = findViewById(R.id.btn_psot);
        tv_result = findViewById(R.id.tv_result);
        tv_result2 = findViewById(R.id.tv_result2);

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_username.getText().toString().trim();
                String password = edt_password.getText().toString().trim();z
                processData(name, password);

            }
        });




    }

    public void processData(String user, String password){

        Call<responseModel> calling = api_controller.getInstance().getAllApi().getData(user,password);

        calling.enqueue(new Callback<responseModel>() {
            @Override
            public void onResponse(Call<responseModel> call, Response<responseModel> response) {
                Toast.makeText(MainActivity.this,"Success ! ",Toast.LENGTH_LONG).show();

                responseModel responseobj = response.body();
                tv_result.setText(responseobj.getUsername());
                tv_result2.setText(responseobj.getPassword());


            }

            @Override
            public void onFailure(Call<responseModel> call, Throwable t) {

            }
        });


    }

}