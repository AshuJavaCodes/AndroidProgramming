package com.redeyesncode.razorpay;

public class PaymentInstrument {

    private String type;
    private String targetApp;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTargetApp() {
        return targetApp;
    }

    public void setTargetApp(String targetApp) {
        this.targetApp = targetApp;
    }

    public PaymentInstrument() {
    }

    public PaymentInstrument(String type, String targetApp) {
        this.type = type;
        this.targetApp = targetApp;
    }
}
