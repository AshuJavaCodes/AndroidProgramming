package com.redeyesncode.retrofitsampleintegerationandroid.dataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginInputBody {
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("deviceToken")
    @Expose
    private String deviceToken;
    @SerializedName("deviceType")
    @Expose
    private String deviceType;
    @SerializedName("deviceName")
    @Expose
    private String deviceName;
    @SerializedName("deviceVersion")
    @Expose
    private String deviceVersion;
    @SerializedName("appVersion")
    @Expose
    private String appVersion;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceVersion() {
        return deviceVersion;
    }

    public void setDeviceVersion(String deviceVersion) {
        this.deviceVersion = deviceVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

}
