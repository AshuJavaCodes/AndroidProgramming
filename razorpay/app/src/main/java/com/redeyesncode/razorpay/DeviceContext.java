package com.redeyesncode.razorpay;

public class DeviceContext {

    private String deviceOS;

    public String getDeviceOS() {
        return deviceOS;
    }

    public DeviceContext() {
    }

    public void setDeviceOS(String deviceOS) {
        this.deviceOS = deviceOS;
    }

    public DeviceContext(String deviceOS) {
        this.deviceOS = deviceOS;
    }
}
