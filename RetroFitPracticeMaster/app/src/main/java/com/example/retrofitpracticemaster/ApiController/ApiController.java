package com.example.retrofitpracticemaster.ApiController;

import com.example.retrofitpracticemaster.ApiInterface.Api_Interface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {
    private static final String url = "http://xx.xxx.xxx.xx:xxxx/WebsiteFolder/";
    private static ApiController apiController;
    private static Retrofit retrofit;


    public ApiController() {
        retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

    }
    public static synchronized ApiController getInstance(){
        if(apiController==null){
            apiController = new ApiController();
        }
        return apiController;
    }
    public Api_Interface apiset(){
        return retrofit.create(Api_Interface.class);

    }

}
