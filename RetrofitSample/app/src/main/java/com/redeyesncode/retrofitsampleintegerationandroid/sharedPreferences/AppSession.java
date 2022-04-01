package com.redeyesncode.retrofitsampleintegerationandroid.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSession {
    public static AppSession yourPreference;
    public SharedPreferences sharedPreferences;

    public static AppSession getInstance(Context context) {
        if (yourPreference == null) {
            yourPreference = new AppSession(context);
        }
        return yourPreference;
    }

    public void clear() {
        sharedPreferences.edit().clear().commit();
    }

    public AppSession(Context context) {
        sharedPreferences = context.getSharedPreferences(Constant.PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public void setValue(String key, String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }

    public String getValue(String key) {
        if (sharedPreferences != null) {
            return sharedPreferences.getString(key, "");
        }
        return "";
    }

}
