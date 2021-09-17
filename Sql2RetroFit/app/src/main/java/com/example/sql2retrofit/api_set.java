package com.example.sql2retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface api_set {

    @FormUrlEncoded
    @GET("Login.php")
    Call<List<ResponseModelOneField>> getData(
            @Field("user") String username,
            @Field("email") String email
    );


}
