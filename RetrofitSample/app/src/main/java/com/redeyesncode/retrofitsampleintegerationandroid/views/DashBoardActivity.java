package com.redeyesncode.retrofitsampleintegerationandroid.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.redeyesncode.retrofitsampleintegerationandroid.R;
import com.redeyesncode.retrofitsampleintegerationandroid.dataModel.CustomerLoginResponseModel;
import com.redeyesncode.retrofitsampleintegerationandroid.dataModel.HomeResponse;
import com.redeyesncode.retrofitsampleintegerationandroid.dataModel.LoginInputBody;
import com.redeyesncode.retrofitsampleintegerationandroid.retrofitService.ApiInterface;
import com.redeyesncode.retrofitsampleintegerationandroid.retrofitService.RetrofitService;
import com.redeyesncode.retrofitsampleintegerationandroid.sharedPreferences.AppSession;
import com.redeyesncode.retrofitsampleintegerationandroid.sharedPreferences.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        String accessTokenSession = AppSession.getInstance(DashBoardActivity.this).getValue(Constant.ACCESS_TOKEN_SHARED_PREFERENCES);

        ApiInterface apiInterface = RetrofitService.createService(ApiInterface.class);
            Call<HomeResponse> call = apiInterface.home(accessTokenSession);
            call.enqueue(new Callback<HomeResponse>() {
                @Override
                public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {



                }

                @Override
                public void onFailure(Call<HomeResponse> call, Throwable t) {

                }
            });



        }
    }