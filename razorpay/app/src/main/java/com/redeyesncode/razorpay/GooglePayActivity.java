package com.redeyesncode.razorpay;

import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.PaymentData;
import com.google.android.gms.wallet.PaymentDataRequest;
import com.google.android.gms.wallet.PaymentsClient;
import com.redeyesncode.razorpay.databinding.ActivityGooglePayBinding;

import org.json.JSONObject;

public class GooglePayActivity extends AppCompatActivity {

    private ActivityGooglePayBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGooglePayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initClicks();
    }
    public Task<PaymentData> getLoadPaymentDataTask(final long priceCents) {
        JSONObject paymentDataRequestJson = PaymentUtil.getPaymentDataRequest(priceCents);
        if (paymentDataRequestJson == null) {
            return null;
        }

        PaymentDataRequest request =
                PaymentDataRequest.fromJson(paymentDataRequestJson.toString());
        PaymentsClient paymentsClient;
        paymentsClient = PaymentUtil.createPaymentsClient(getApplicationContext());
        return paymentsClient.loadPaymentData(request);
    }
    private void initClicks() {
        binding.googlePayButton.btnGooglePayButton.setOnClickListener(v -> {
            long dummyPriceCents = 100;
            long shippingCostCents = 900;
            long totalPriceCents = dummyPriceCents + shippingCostCents;
            final Task<PaymentData> task = getLoadPaymentDataTask(totalPriceCents);

            task.addOnCompleteListener(completedTask -> {
                if (completedTask.isSuccessful()) {
                    showToast("SUCCESS PAYMENT !");
                }else{
                    showToast("FAILED PAYMENT" + completedTask.getException().getMessage());
                    Log.i("DEV_ASHUTOSH", "initClicks: "+completedTask.getException().getMessage());

                }
            });
            task.addOnFailureListener(e -> {
                showToast(e.getMessage());
                Log.i("DEV_ASHUTOSH", "initClicks: "+e.getMessage());

            });
        });
    }
    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}