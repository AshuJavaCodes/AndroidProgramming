package com.redeyesncode.retrofitsampleintegerationandroid.retrofitService;


import com.redeyesncode.retrofitsampleintegerationandroid.dataModel.CustomerLoginResponseModel;
import com.redeyesncode.retrofitsampleintegerationandroid.dataModel.HomeResponse;
import com.redeyesncode.retrofitsampleintegerationandroid.dataModel.LoginInputBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

//This interface contains all the api listing
public interface ApiInterface {



    //Type of Api(Name of APi)
    //Call<REsponseFromApi> interfaceMethodName(@Body LoginInputBOdy loginBody);

    //Convert the json of response and the input body from this link
    /*https://www.jsonschema2pojo.org/*/

    //Get the type and the name of the api you want to integerate
    @POST("login")
        Call<CustomerLoginResponseModel> loginApi(@Body LoginInputBody loginInputBody);


    //TO ADD THE JWT ACCESS TOKEN TO THE API WE THE THE FOLLOWING SYNTAX;

    //Type of Api(Name of APi)
    //Call<REsponseFromApi> interfaceMethodName(@Header("HEADER_NAME/TOKEN_NAME >> GENERALLY "Authorization") String accessToken);

    @GET("home")
    Call<HomeResponse> home(@Header("Authorization") String token);






}
