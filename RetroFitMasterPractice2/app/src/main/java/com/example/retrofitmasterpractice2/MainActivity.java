package com.example.retrofitmasterpractice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.retrofitmasterpractice2.Api_Controller.Api_Controller;
import com.example.retrofitmasterpractice2.ResponseModels.LoginResponseModel;
import com.example.retrofitmasterpractice2.databinding.ActivityMainBinding;

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
        //View Binding Done.

        mainBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile =mainBinding.edtMobile.getText().toString();
                String password = mainBinding.edtPassword.getText().toString();
                processData(mobile,password);
            }
        });


    }
    public void processData(String mobile,String password){
        Call<LoginResponseModel> call = Api_Controller.getInstance().getApiSet().LoginApi(mobile,password);
        call.enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                LoginResponseModel loginobj = response.body();
                //FirstStoringItIntoAString.
                Integer parentId = loginobj.getData().get(0).getParentId();
                String parentIdString = String.valueOf(parentId);

                mainBinding.parentaddress.setText(loginobj.getData().get(0).getParentAddress());
                mainBinding.loginmsg.setText(loginobj.getMessage());
                mainBinding.parentid.setText(parentIdString);
                mainBinding.parentname.setText(loginobj.getData().get(0).getParentName());


            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Something Went Wrong",Toast.LENGTH_LONG).show();
            }
        });
    }
}