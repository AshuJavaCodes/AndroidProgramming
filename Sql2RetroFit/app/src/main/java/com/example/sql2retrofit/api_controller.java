package com.example.sql2retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class api_controller {
    private static final String url = "url here";
    private static api_controller clientObject;
    private static Retrofit retrofit;

    api_controller{

        retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

    }
    public static synchronized api_controller getInstance(){
        if(clientObject==null){
            clientObject = new api_controller();
        }
        return clientObject;
    }
    api_set getApiSet(){
       return  retrofit.create(api_set.class);

    }


}
