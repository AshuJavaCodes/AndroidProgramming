package com.redeyesncode.razorpay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PayloadHelper;
import com.razorpay.PaymentResultListener;
import com.redeyesncode.razorpay.databinding.ActivityRazorPayBinding;

import org.json.JSONException;
import org.json.JSONObject;

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

    }

    @Override
    public void onPaymentError(int i, String s) {
        showToast(s);
        Log.i("DEV_ASHUTOSH", "onPaymentError: "+s);
        binding.tvPaymentStatus.setText("FAILED PAYMENT !");


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

    private void setupPaymentFlow(){
        Checkout checkout = new Checkout();
        checkout.setKeyID("RAZOR_PAY_LIVE_KEY_HERE");
        // Using Large image cause problems.
//        checkout.setImage(R.drawable.hotel_ic);


        PayloadHelper payloadHelper = new PayloadHelper("INR", 100, "order_L7bkerUGm8DAKr");
        payloadHelper.setAmount(100);
        payloadHelper.setCurrency("INR");
        payloadHelper.setOrderId("order_L7bkerUGm8DAKr");

        JSONObject jsonObject = payloadHelper.getJson();
        // Convert payload helper to json object android.

        checkout.open(RazorPayActivity.this,jsonObject);


    }

    private void initClicks(){

        binding.btnRazorPay.setOnClickListener(v -> {
            setupPaymentFlow();
//            setupJsonPaymentFlow();


        });

    }

    private void setupRazorPay() {
        /*$keyId="rzp_live_vbHedWXko3D1wH";
$keySecret="B0EyozZkR9jGX0e1NWq7HcaZ";*/
        Checkout.preload(RazorPayActivity.this);







    }
}