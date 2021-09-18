package com.example.retrofitmasterpractice2.Api_Controller;

import com.example.retrofitmasterpractice2.Api_Interface.Api_Interface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_Controller {
    private static final String url = "http://xx.xxx.xxx.xx:xxxx/WebsiteFolder/";
    private static Api_Controller apiController;
    private static Retrofit retrofit;

    public Api_Controller() {
        retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static synchronized Api_Controller getInstance(){
        if(apiController==null){
        apiController= new Api_Controller();
        }
        return apiController;
    }
    public Api_Interface getApiSet(){
        return retrofit.create(Api_Interface.class);
    }

}
