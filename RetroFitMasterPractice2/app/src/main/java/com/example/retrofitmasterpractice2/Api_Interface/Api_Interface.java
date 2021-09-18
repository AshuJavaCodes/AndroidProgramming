package com.example.retrofitmasterpractice2.Api_Interface;

import com.example.retrofitmasterpractice2.ResponseModels.LoginResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api_Interface {
    @FormUrlEncoded
    @POST("appLoginNewDevice")
    Call<LoginResponseModel> LoginApi(
            @Field("value") String number,
            @Field("password") String password
    );

}
