package com.redeyesncode.razorpay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.redeyesncode.razorpay.databinding.ActivityMainBinding;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetResult;
import com.stripe.android.paymentsheet.PaymentSheetResultCallback;

public class MainActivity extends AppCompatActivity implements PaymentSheetResultCallback  {

    private ActivityMainBinding binding;
    private PaymentSheet paymentSheet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        initClicks();
        setupRazorPay();
        setContentView(binding.getRoot());
    }

    private void setupRazorPay() {
        PaymentConfiguration.init(MainActivity.this, String.valueOf(R.string.RAZOR_PAY_PUBLISABLE_KEY));
        paymentSheet = new PaymentSheet(this,this::onPaymentSheetResult);
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



    private void presentPaymentSheet(){

        // Here we need two keys from the back-end server itself. which are.
        // Customer-id key and the ephemeralKey (client-secret) key from backend itself.

        /*{
    "CLIENT_SECRET": "pi_3MTME5SGxlhGWErC0vNGcaaH_secret_RzQqK8EI0BeGnlSgCUtLurZMe",
    "CLIENT_CURRENCY": "usd",
    "CLIENT_ID": "pi_3MTME5SGxlhGWErC0vNGcaaH"
}*/



        String CLIENT_ID = binding.edtCustomerId.getText().toString();
        String CLIENT_SECRET = binding.edtEmpheralKey.getText().toString();

        // Showing Invalid Client Secret.


        PaymentSheet.CustomerConfiguration customerConfiguration = new PaymentSheet.CustomerConfiguration(CLIENT_ID,CLIENT_SECRET);
//        PaymentSheet.CustomerConfiguration customerConfiguration = new PaymentSheet.CustomerConfiguration("pi_3MTMPKSGxlhGWErC1ZjNfndN_secret_zfOoK3tptET9HzhI4OHp88WpT","pi_3MTMPKSGxlhGWErC1ZjNfndN");
//        paymentSheet.presentWithPaymentIntent(String.valueOf(R.string.RAZOR_PAY_SECRET_KEY), new PaymentSheet.Configuration("HotelSwag-Stay",customerConfiguration));
        paymentSheet.presentWithPaymentIntent(String.valueOf(R.string.RAZOR_PAY_PUBLISABLE_KEY),new PaymentSheet.Configuration("SwagStay-Hotel",customerConfiguration));
//        paymentSheet.presentWithSetupIntent(CLIENT_SECRET, new PaymentSheet.Configuration("HotelSwag-Stay",customerConfiguration));
    }


    private void initClicks() {
        binding.btnStripe.setOnClickListener(v -> {
            presentPaymentSheet();
        });

        binding.btnPhonePe.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,PhonePeActivity.class));


        });

        binding.btnLinkType.setOnClickListener(v -> {

            // Stripe test cards --> 4242424242424242
            String paymentLink = "";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(paymentLink));
            startActivity(i);

        });
        binding.btnFormType.setOnClickListener(v -> {
            Intent razorPayIntent = new Intent(MainActivity.this,RazorPayActivity.class);
            startActivity(razorPayIntent);
        });

        binding.btnGpay.setOnClickListener(v -> {
            Intent gpayIntent = new Intent(MainActivity.this,GooglePayActivity.class);
            startActivity(gpayIntent);

        });


    }

    private void askPermission(){
        // Sometime stripe needs location permission as well for certain payments.
    }

    @Override
    public void onPaymentSheetResult(@NonNull PaymentSheetResult paymentSheetResult) {
        showToast("OnPaymentSheetResult."+paymentSheetResult.toString());
        Log.i("DEV_ASHUTOSH", "onPaymentSheetResult: "+paymentSheetResult.toString());




        // You will get callback here it self (Can Also check in the Activity LifeCycle Callbacks)
//        PaymentSheetResult.Failed
//        PaymentSheetResult.Canceled
//        PaymentSheetResult.Completed
    }

    private void showToast(String message){

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}