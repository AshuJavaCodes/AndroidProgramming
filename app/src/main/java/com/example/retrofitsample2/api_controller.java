package com.example.retrofitsample2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;

public class api_controller {

    private static final String url= "PASTE YOUR URL HERE";
    private static api_controller client;
    private static Retrofit retroObj;

    api_controller{
        //GSON FACTORY NOT GETTING IMPORTED
        retroObj = new Retrofit.Builder().baseUrl(url).addConverterFactory(Gson.create());

    }

    public static synchronized api_controller getInstance(){

        if(client==null){
            client =  new api_controller();
        } else{
            return client;
        }
    }
    connect_2_api getAllApi(){
        return  retroObj.create(connect_2_api.class);

    }





}
