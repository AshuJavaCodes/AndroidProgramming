package com.redyesncode.sharedpreferencesandroid.session;

import android.content.Context;
import android.content.SharedPreferences;


// YOU CAN NAME THIS CLASS ACCORDING TO YOUR CHOICE.
public class AppSession {

    // STEP 1: CREATE A MEMBER VARIABLE OF THIS CLASS IT SELF.
    public static AppSession yourPreference;

    // Step 2 : Create Variable for android internal shared preferences.
    public SharedPreferences sharedPreferences;


    // Step 3 : Create Variable for SharedPreferences Editor as well.
    // What is the use of the editor ??
    // Ans : In android whenever we access or want to access Shared pref we do it with the
    // help of editor. editor helps us to put or set value in android internal shared pref.
    private SharedPreferences.Editor prefsEditor;


    //  Step 4 : Analyze this.
    // * It's a method (Name = getInstance)
    // * This method returns AppSession.(Object of the class we are writing this code)
    // * if value of yourPreference variable is null this method will create new object.
    // IMPORTANT NOTE : This METHOD SHOULD BE STATIC
    // * This method takes a parameter context.
    //IMPORTANT NOTE : Context is must for shared pref.

    public static AppSession getInstance(Context context) {
        if (yourPreference == null) {
            yourPreference = new AppSession(context);
        }
        return yourPreference;
    }

    // Step 5 : Create a method which clears all the keys and values that are stored
    // in the android internal shared pref.
    // In android whenever we access or want to access Shared pref we do it with the
    // help of editor. editor helps us to put or set value in android internal shared pref.
    // Without edit(), shared pref. are nothing.
    public void clear() {
        sharedPreferences.edit().clear().apply();
    }


    // Step 6 : Create a constructor of the class itself. which takes the context.
    public AppSession(Context context) { // this context comes from the UI wherever we use it.
        sharedPreferences = context.getSharedPreferences(Constants.PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    // From here , we define methods according to our requirements.

    public void setValue(String key, String value) {
        prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    public String getValue(String key) {
        if (sharedPreferences != null) {
            return sharedPreferences.getString(key, "");
        }
        return "";
    }

    public void setBoolean(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(key, defaultValue);
        }
        return false;
    }



    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void putString(String key, String value) {
        checkForNullKey(key);
        checkForNullValue(value);
        sharedPreferences.edit().putString(key, value).apply();
    }

    public boolean checkForNullKey(String key) {
        return key == null;
    }

    public void checkForNullValue(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
    }

}
