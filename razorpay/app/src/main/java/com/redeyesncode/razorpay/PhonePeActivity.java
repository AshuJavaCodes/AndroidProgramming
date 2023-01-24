package com.redeyesncode.razorpay;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
//import com.phonepe.intent.sdk.api .PhonePe;
//import com.phonepe.intent.sdk.api.PhonePeInitException;
//import com.phonepe.intent.sdk.api.UPIApplicationInfo;
import com.phonepe.intent.sdk.api.B2BPGRequest;
import com.phonepe.intent.sdk.api.B2BPGRequestBuilder;
import com.phonepe.intent.sdk.api.PhonePe;
import com.phonepe.intent.sdk.api.PhonePeInitException;
import com.phonepe.intent.sdk.api.UPIApplicationInfo;
import com.redeyesncode.razorpay.databinding.ActivityPhonePeBinding;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

public class PhonePeActivity extends AppCompatActivity {

    private ActivityPhonePeBinding binding;

    private final int B2B_PAYMENT_REQUEST_CODE = 7777;

    private final int UPI_PAYMENT_REQUEST_CODE = 8989;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhonePeBinding.inflate(getLayoutInflater());
        initClicks();
        // TODO : FACING DIFFICULTY IN PHONE PE DEPENDENCY of Gradle.
        PhonePe.init(PhonePeActivity.this);

        setContentView(binding.getRoot());
    }
    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
    private void initClicks() {

        binding.btnUpiApps.setOnClickListener(v -> {
            try {
                List<UPIApplicationInfo> upiApps = PhonePe.getUpiApps();
                showToast("The COUNT of UPI apps are as follows--> "+String.valueOf(upiApps.size()));
            } catch (PhonePeInitException exception) {
                exception.printStackTrace();
                showToast(exception.getMessage());
            }
        });



        binding.btnUpiIntent.setOnClickListener(v -> {
            HashMap<String, Object> data = new HashMap();
            data.put("merchantTransactionId","txnId");
            data.put("merchantId", "merchantId");
            data.put("merchantUserId", "u123");
            data.put("amount",200);
            data.put("mobileNumber","6261319133");
            data.put("callbackUrl","https://webhook.site/callback-url");

            PaymentInstrument mPaymentInstrument = new PaymentInstrument();
            mPaymentInstrument.setType("UPI_INTENT");
            // Here you can put various package name of the different ui's
            // TODO : FOR NOW WE ARE OPENING UP PAYTM.
            mPaymentInstrument.setTargetApp("net.one97.paytm");
            data.put("paymentInstrument",mPaymentInstrument);

            DeviceContext mDeviceContext = new DeviceContext();
            mDeviceContext.setDeviceOS("ANDROID");
            data.put("deviceContext",mDeviceContext);

            // TODO : Unable to import Json to Base64 class of Android.
            String jsonString = new Gson().toJson(data);
            byte[] byteArrayJsonString = jsonString.getBytes(StandardCharsets.UTF_8);

            String base64Body = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                base64Body = Base64.getEncoder().encodeToString(byteArrayJsonString);
            }

            // Checksum and ApiEndPoint Are the two things needed from backend.


            // These 3 points are needed from the backend in order for PhonePe SDK to work.
            // checksum, apiEndpoint, base64Body
            B2BPGRequest b2BPGRequest = new B2BPGRequestBuilder()
                    .setData("base64Body")
                    .setChecksum("checksum")
                    .setUrl("apiEndPoint")
                    .build();
            try {
                startActivityForResult(PhonePe.getImplicitIntent(this,b2BPGRequest,"net.one97.paytm"),B2B_PAYMENT_REQUEST_CODE);
            }catch (Exception e){
                e.printStackTrace();
                showToast("PAYTM is not installed on this device.");
            }


        });

        binding.btnSdkLessPhonePe.setOnClickListener(v -> {
            try {
                if(PhonePe.getUpiApps().isEmpty()){
                    showToast("Device does not have any UPI Apps.");
                }else{
                    payUsingUpi("100","vancher571@oksbi","Ashutosh Singh","PhonePe SDK-less Intent");

                }
            } catch (PhonePeInitException e) {
                e.printStackTrace();
                showToast(e.getMessage());
            }

        });



    }

    public void payUsingUpi( String amount, String upiId, String name, String note) {

        Uri uri = Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa", upiId)
                .appendQueryParameter("pn", name)
                .appendQueryParameter("tn", note)
                .appendQueryParameter("am", amount)
                .appendQueryParameter("cu", "INR")
                .build();

        Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);

        // will always show a dialog to user to choose an app
        Intent chooser = Intent.createChooser(upiPayIntent, "Pay with");

        // check if intent resolves
        if (null != chooser.resolveActivity(getPackageManager())) {
            startActivityForResult(chooser, UPI_PAYMENT_REQUEST_CODE);
        } else {
            Toast.makeText(this, "No UPI app found, please install one to continue", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == UPI_PAYMENT_REQUEST_CODE && resultCode== RESULT_OK || resultCode == 11){
            if (data != null) {
                String trxt = data.getStringExtra("response");
                Log.e("UPI", "onActivityResult: "+trxt);
                ArrayList<String> dataList = new ArrayList<String>();
                dataList.add(trxt);
                upiPaymentDataOperation(dataList);
            } else {
                Log.e("UPI", "onActivityResult: " + "Return data is null");
                ArrayList<String> dataList = new ArrayList<String>();
                dataList.add("nothing");
                upiPaymentDataOperation(dataList);
            }
        }else{
            Log.e("UPI", "onActivityResult: " + "Return data is null"); //when user simply back without payment
            ArrayList<String> dataList = new ArrayList<String>();
            dataList.add("nothing");
            upiPaymentDataOperation(dataList);
        }
    }


    private void upiPaymentDataOperation(ArrayList<String> data) {
        String str = data.get(0);
        Log.e("UPIPAY", "upiPaymentDataOperation: " + str);
        String paymentCancel = "";
        if (str == null) str = "discawrd";
        String status = "";
        String approvalRefNo = "";
        String txnRef = "";
        String responseCode = "";
        String txnId = "";

        String[] response = str.split("&");
        for (String res : response) {
            String[] equalStr = res.split("=");
            if (equalStr.length >= 2) {
                if (equalStr[0].equalsIgnoreCase("Status")) {
                    status = equalStr[1].toLowerCase();
                }
                if (equalStr[0].equalsIgnoreCase("ApprovalRefNo")) {
                    approvalRefNo = equalStr[1];
                }
                if (equalStr[0].equalsIgnoreCase("txnRef")) {
                    txnRef = equalStr[1];
                } if (equalStr[0].equalsIgnoreCase("txnId")) {
                    txnId = equalStr[1];
                }
            }else{
                paymentCancel = "Payment cancelled by user.";
            }
        }

        if (status.equalsIgnoreCase("success")) {
            //Code to handle successful transaction here.
            Toast.makeText(this, "Transaction successfull.", Toast.LENGTH_SHORT).show();
            binding.tvPaymentStatus.setTextColor(getColor(R.color.white));
            binding.tvPaymentStatus.setText("Transaction successfull.");
            binding.tvPaymentStatus.setBackgroundColor(getColor(R.color.green));
            Log.e("UPI", "txnId: "+txnId);
            Log.e("UPI", "responseStr: "+approvalRefNo);
            Log.e("UPI", "txnRef: "+txnRef);
        } else if (paymentCancel.equalsIgnoreCase("Payment cancelled by user.")) {
            Toast.makeText(this, "Payment cancelled by user.", Toast.LENGTH_SHORT).show();
            binding.tvPaymentStatus.setTextColor(getColor(R.color.white));
            binding.tvPaymentStatus.setText("Payment cancelled by user.");
            binding.tvPaymentStatus.setBackgroundColor(getColor(R.color.red));
        } else {
            Toast.makeText(this, "Transaction failed.Please try again", Toast.LENGTH_SHORT).show();
            binding.tvPaymentStatus.setTextColor(getColor(R.color.white));
            binding.tvPaymentStatus.setText("Transaction failed. Please try again.");
            binding.tvPaymentStatus.setBackgroundColor(getColor(R.color.red));
        }
    }

}