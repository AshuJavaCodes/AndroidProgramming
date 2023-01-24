package com.redeyesncode.razorpay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
//import com.phonepe.intent.sdk.api .PhonePe;
//import com.phonepe.intent.sdk.api.PhonePeInitException;
//import com.phonepe.intent.sdk.api.UPIApplicationInfo;
import com.redeyesncode.razorpay.databinding.ActivityPhonePeBinding;

import java.util.HashMap;
import java.util.List;

public class PhonePeActivity extends AppCompatActivity {

    private ActivityPhonePeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhonePeBinding.inflate(getLayoutInflater());
//        initClicks();
        // TODO : FACING DIFFICULTY IN PHONE PE DEPENDENCY of Gradle.

//        PhonePe.init(PhonePeActivity.this);
        setContentView(binding.getRoot());
    }
    private void showToast(String message){

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
//    private void initClicks() {
//
//        binding.btnUpiApps.setOnClickListener(v -> {
//            try {
//                List<UPIApplicationInfo> upiApps = PhonePe.getUpiApps();
//                showToast("The List of UPI apps are as follows"+String.valueOf(upiApps.size()));
//            } catch (PhonePeInitException exception) {
//                exception.printStackTrace();
//            }
//        });
//
//
//
//        binding.btnUpiIntent.setOnClickListener(v -> {
//            HashMap<String, Object> data = new HashMap();
//            data.put("merchantTransactionId","txnId");
//            data.put("merchantId", "merchantId");
//            data.put("merchantUserId", "u123");
//            data.put("amount",200);
//            data.put("mobileNumber","6261319133");
//            data.put("callbackUrl","https://webhook.site/callback-url");
//
//            PaymentInstrument mPaymentInstrument = new PaymentInstrument();
//            mPaymentInstrument.setType("UPI_INTENT");
//            // Here you can put various package name of the different ui's
//            mPaymentInstrument.setTargetApp("<Package name of the UPI App to be opened>");
//            data.put("paymentInstrument",mPaymentInstrument);
//
//            DeviceContext mDeviceContext = new DeviceContext();
//            mDeviceContext.setDeviceOS("ANDROID");
//            data.put("deviceContext",mDeviceContext);
//
//            // TODO : Unable to import Json to Base64 class of Android.
//
////            String base64Body = new Base64(new Gson().toJson(data));
//
//        });
//
//
//
//    }
}