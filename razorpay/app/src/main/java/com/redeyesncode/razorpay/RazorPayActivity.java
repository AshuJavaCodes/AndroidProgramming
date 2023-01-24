package com.redeyesncode.razorpay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.razorpay.Checkout;
import com.razorpay.PayloadHelper;
import com.razorpay.PaymentResultListener;
import com.redeyesncode.razorpay.databinding.ActivityRazorPayBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RazorPayActivity extends AppCompatActivity implements PaymentResultListener {

    private ActivityRazorPayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRazorPayBinding.inflate(getLayoutInflater());

        setupRazorPay();
        initClicks();


        setContentView(binding.getRoot());
    }
    @Override
    protected void onResume() {
        super.onResume();
        showToast("onResume : Lifecycle Callback");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showToast("onRestart : Lifecycle Callback");

    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("onPause : Lifecycle Callback");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop : Lifecycle Callback");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart : Lifecycle Callback");
    }

    @Override
    public void onPaymentSuccess(String s) {
        showToast("Payment Successfully done !");
        Log.i("DEV_ASHUTOSH", "onPaymentSuccess: "+s);
        binding.tvPaymentStatus.setText("SUCCESS PAYMENT !");
        binding.tvPaymentStatus.setTextColor(getColor(R.color.white));
        binding.tvPaymentStatus.setBackgroundColor(getColor(R.color.black));
        binding.edtRazorOrderId.setText("");
    }

    @Override
    public void onPaymentError(int i, String s) {
        showToast(s);
        Log.i("DEV_ASHUTOSH", "onPaymentError: "+s);
        binding.tvPaymentStatus.setText("FAILED PAYMENT !");
        binding.tvPaymentStatus.setTextColor(getColor(R.color.white));
        binding.tvPaymentStatus.setBackgroundColor(getColor(R.color.red));
        binding.edtRazorOrderId.setText("");

    }

    private void showToast(String message){

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void setupJsonPaymentFlow(){
        Checkout checkout = new Checkout();
        checkout.setKeyID(String.valueOf(R.string.RAZOR_PAY_SECRET_KEY));
//        checkout.setImage(R.drawable.hotel_ic);
        JSONObject options = new JSONObject();

       try {
           options.put("name", "Merchant Name");
           options.put("description", "Reference No. #123456");
           options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg");
           options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
           options.put("theme.color", "#3399cc");
           options.put("currency", "INR");
           options.put("amount", "50000");//pass amount in currency subunits
           options.put("prefill.email", "gaurav.kumar@example.com");
           options.put("prefill.contact","9988776655");
           JSONObject retryObj = new JSONObject();
           retryObj.put("enabled", true);
           retryObj.put("max_count", 4);
           options.put("retry", retryObj);

           checkout.open(RazorPayActivity.this, options);
       }catch (JSONException e){
           e.printStackTrace();
       }


    }

    private void setupPaymentFlow() throws JSONException {
        Checkout checkout = new Checkout();

        // Please Don't use String.valueof(R.string.RAZOR_PAY_KEY)
        checkout.setKeyID("rzp_test_CoEUjcxQj6CkhA");
        // Using Large image cause problems.
//        checkout.setImage(R.drawable.hotel_ic);

        //Using Payload helper.
        PayloadHelper payloadHelper = new PayloadHelper("INR", 100, binding.edtRazorOrderId.getText().toString());
        payloadHelper.setAmount(100);
        payloadHelper.setCurrency("INR");
        payloadHelper.setOrderId(binding.edtRazorOrderId.getText().toString());
        JSONObject payloadHelperJsonObject = payloadHelper.getJson();

        // Using JsonObject
//        JSONObject options = new JSONObject();
//        options.put("order_id","order_L7yiOvkdChcXOk");
//        options.put("name","ashutosh_singh");
//        options.put("currency", "INR");
//        options.put("amount", "50000");

        // Convert payload helper to json object android.
        checkout.open(RazorPayActivity.this,payloadHelperJsonObject);
    }

    private void checkOrderStatusByVolley(String orderId) throws JSONException {
        // We can call this method or this specific api again to check.
//        https://api.razorpay.com/v1/orders/{order_id}
        // For calling Api's in Volley (RequestQueue) is required.
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        String RAZOR_PAY_URL = "https://api.razorpay.com/v1/orders/"+orderId;

        // TODO : NEED TO PASS BASIC AUTH PARAMS TO THE VOLLEY REQUEST AS WELL.
        JSONObject params = new JSONObject();
        params.put("username", "rzp_test_CoEUjcxQj6CkhA");
        params.put("password", "uCfEVHanVkZTDHbDqluSSQSb");

        // JsonObject-Request as we are getting JSON-Object in response.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, RAZOR_PAY_URL, null, response -> {
            // Success Response is noted here.
            binding.tvOrderPaymentStatus.setTextColor(getColor(R.color.white));
            try {
//                binding.tvOrderPaymentStatus.setText(response.getJSONObject("nameValuePairs")
//                        .getJSONObject("items")
//                        .getJSONArray("values")
//                        .getJSONObject(0)
//                        .getJSONObject("nameValuePairs")
//                        .getString("status"));
            }catch (Exception e){
                // Cannot parse json data hence showing it all.
//                binding.tvOrderPaymentStatus.setText(new Gson().toJson(response));
                Log.i("DEV_ASHUTOSH", "checkOrderStatus: "+new Gson().toJson(response));
            }
//            binding.tvOrderPaymentStatus.setBackgroundColor(getColor(R.color.green));
        }, error -> {
            // Error Response is noted here.
            showToast("Error");
            Log.i("DEV_ASHUTOSH", "checkOrderStatus: "+error.toString());
//            binding.tvOrderPaymentStatus.setTextColor(getColor(R.color.white));
//            binding.tvOrderPaymentStatus.setText(error.toString());
//            binding.tvOrderPaymentStatus.setBackgroundColor(getColor(R.color.red));
        }){
            // Razor-Pay Needs Basic Type of Auth. (Base64 String format)
            // Overide below method to give specific keys to razor pay.
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                // Get base64 key from postman itself.
                headers.put("Authorization", "Basic cnpwX3Rlc3RfQ29FVWpjeFFqNkNraEE6dUNmRVZIYW5Wa1pUREhiRHFsdVNTUVNi");
                return headers;
            }

            // In-Order to Handle 200,400 Success & Error Code.
            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                if(response.statusCode==400){
//                    binding.tvOrderPaymentStatus.setTextColor(getColor(R.color.white));
//                    binding.tvOrderPaymentStatus.setText("400 Bad Request");
//                    binding.tvOrderPaymentStatus.setBackgroundColor(getColor(R.color.red));
                }

                return super.parseNetworkResponse(response);
            }
        };

        // At last, call the api.
        requestQueue.add(jsonObjectRequest);
    }



    private void initClicks(){

        binding.btnRazorPay.setOnClickListener(v -> {
            try {
                if(binding.edtRazorOrderId.getText().toString().isEmpty()){
                    showToast("Please enter Order Id");
                }else{
                    setupPaymentFlow();

                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
//            setupJsonPaymentFlow();


        });

        binding.btnRazorPayOrderStatus.setOnClickListener(v -> {
            if(binding.edtRazorStatus.getText().toString().isEmpty()){
                showToast("Please enter razor pay id.");
            }else{
                try {
                    checkOrderStatusByVolley(binding.edtRazorOrderId.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });



    }

    private void setupRazorPay() {
        Checkout.preload(RazorPayActivity.this);
    }
}