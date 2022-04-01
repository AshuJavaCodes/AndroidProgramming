package com.redeyesncode.retrofitsampleintegerationandroid.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.redeyesncode.retrofitsampleintegerationandroid.R;
import com.redeyesncode.retrofitsampleintegerationandroid.dataModel.CustomerLoginResponseModel;
import com.redeyesncode.retrofitsampleintegerationandroid.dataModel.LoginInputBody;
import com.redeyesncode.retrofitsampleintegerationandroid.retrofitService.ApiInterface;
import com.redeyesncode.retrofitsampleintegerationandroid.retrofitService.RetrofitService;
import com.redeyesncode.retrofitsampleintegerationandroid.sharedPreferences.AppSession;
import com.redeyesncode.retrofitsampleintegerationandroid.sharedPreferences.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    EditText editTextNumber;
    EditText editTextPassword;
    Button loginButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewClicks();



    }


    private void initViewClicks(){
        editTextNumber = findViewById(R.id.edtNumber);
        editTextPassword = findViewById(R.id.edtPassword);
        loginButton = findViewById(R.id.btnLogin);
        textView = findViewById(R.id.tvData);

        LoginInputBody loginInputBody = new LoginInputBody();
        loginInputBody.setAppVersion("");
        loginInputBody.setDeviceName("ANDROID");
        loginInputBody.setDeviceToken("");
        loginInputBody.setDeviceVersion("");
        loginInputBody.setDeviceType("");


        //Important

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editTextNumber.getText().toString().isEmpty() && !editTextPassword.getText().toString().isEmpty()){
                    loginInputBody.setMobileNumber(editTextNumber.getText().toString());
                    loginInputBody.setPassword(editTextPassword.getText().toString());

                    ApiInterface apiInterface = RetrofitService.createService(ApiInterface.class);
                    Call<CustomerLoginResponseModel> call = apiInterface.loginApi(loginInputBody);

                    //REMEMBER THIS ENQUE STEP
                    call.enqueue(new Callback<CustomerLoginResponseModel>() {
                        @Override
                        public void onResponse(Call<CustomerLoginResponseModel> call, Response<CustomerLoginResponseModel> response) {
                            if(response.code()==200){

                                String responseAccessToken = response.body().getData().getToken();
                                AppSession.getInstance(MainActivity.this).setValue(Constant.ACCESS_TOKEN_SHARED_PREFERENCES,responseAccessToken);


                                textView.setText(response.body().getData().getUsername());
                                Toast.makeText(MainActivity.this, "Login Success !", Toast.LENGTH_SHORT).show();


                            }else {
                                textView.setText("Invalid User");
                                Toast.makeText(MainActivity.this, "Login Failed !", Toast.LENGTH_SHORT).show();
                            }


                        }

                        @Override
                        public void onFailure(Call<CustomerLoginResponseModel> call, Throwable t) {

                            Log.i("RETROFIT_ERROR",t.toString());
                        }
                    });

                }


            }
        });


    }
}