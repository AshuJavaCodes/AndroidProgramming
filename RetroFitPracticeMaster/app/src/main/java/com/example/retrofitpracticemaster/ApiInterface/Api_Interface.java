package com.example.retrofitpracticemaster.ApiInterface;

import com.example.retrofitpracticemaster.ResponseModel.LoginResponseModel;

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
