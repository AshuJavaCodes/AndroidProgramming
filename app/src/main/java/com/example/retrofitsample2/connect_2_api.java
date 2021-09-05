package com.example.retrofitsample2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface connect_2_api {

    @FormUrlEncoded
    @POST("LOGIN2.PHP")
    //EXACT SAME FIELDS HERE AS IN PHP.
    Call<responseModel> getData(
            @Field("username") String name,
            @Field("password") String password

    );



}
