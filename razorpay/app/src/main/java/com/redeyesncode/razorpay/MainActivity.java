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

    private void presentPaymentSheet(){

        // Here we need two keys from the back-end server itself. which are.
        // Customer-id key and the ephemeralKey (client-secret) key from backend itself.



        paymentSheet.presentWithPaymentIntent(String.valueOf(R.string.RAZOR_PAY_SECRET_KEY),new PaymentSheet.Configuration("SwagStay-Hotels",new PaymentSheet.CustomerConfiguration("1",String.valueOf(R.string.RAZOR_PAY_SECRET_KEY))));
    }


    private void initClicks() {
        binding.btnStripe.setOnClickListener(v -> {
            presentPaymentSheet();
        });

        binding.btnLinkType.setOnClickListener(v -> {

            // Stripe test cards --> 4242424242424242
            String paymentLink = "";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(paymentLink));
            startActivity(i);

        });
        binding.btnFormType.setOnClickListener(v -> {
            showToast("Please get Empheral Key First.");
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