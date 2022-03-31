package com.redeyesncode.retrofitsampleintegerationandroid.retrofitService;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//This contains the retrofit Builder code and the code to intialze the retrofit
public class RetrofitService {


    //Copy the same exact address from the api provided from the back end developer
    private static final String url = "http://13.56.178.203:8889/customer/";



    //This is used to set the timeout error in retrofit
    private static final OkHttpClient httpClient = new OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS).build();


    //Gson is telling retrofit to send and receive the data from the api in the form of the JSON ONLY
    //So that we can encode and decode it in the java class in android.
    private static final Gson gson = new GsonBuilder().setLenient().create();


    //THis is used to tell retrofit to hit the api at this particular url
    private static final Retrofit.Builder builder = new Retrofit.Builder().baseUrl(url);




    //THis is the important method to set all the paramters in retrofit
    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).
                addConverterFactory(GsonConverterFactory.create(gson)).
                build();
        return retrofit.create(serviceClass);
    }

}
