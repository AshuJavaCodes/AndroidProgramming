package com.example.retrofitpracticemaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.retrofitpracticemaster.ApiController.ApiController;
import com.example.retrofitpracticemaster.ApiInterface.Api_Interface;
import com.example.retrofitpracticemaster.ResponseModel.LoginResponseModel;
import com.example.retrofitpracticemaster.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        //View_Binding_Done.

        //Referencing using View Binding

        mainBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile =mainBinding.edtMobile.getText().toString();
                String password = mainBinding.edtPassword.getText().toString();
                loginUser(mobile,password);
            }
        });

    }
    public void loginUser(String mobile, String password){
        Call<LoginResponseModel> call = ApiController.getInstance().apiset().LoginApi(mobile,password);
        call.enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                LoginResponseModel loginObj = response.body();
                mainBinding.loginmsg.setText(loginObj.getMessage());
                mainBinding.parentid.setText(loginObj.getData().get(0).getParentId());

/*
                String Id = loginObj.getData().get(0).getPare
*/

            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }
}