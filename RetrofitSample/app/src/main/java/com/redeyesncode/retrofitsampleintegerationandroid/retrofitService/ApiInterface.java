package com.redeyesncode.retrofitsampleintegerationandroid.retrofitService;


import com.redeyesncode.retrofitsampleintegerationandroid.dataModel.CustomerLoginResponseModel;
import com.redeyesncode.retrofitsampleintegerationandroid.dataModel.LoginInputBody;

import retrofit2.Call;
import retrofit2.http.Body;
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

}
