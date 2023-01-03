package com.redeyesncode.androidservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyAndroidService :Service() {


    override fun onCreate() {
        super.onCreate()
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        return super.onStartCommand(intent, flags, startId)

        // Action to be performed when the service gets started.

        Log.i("ANDROID_SERVICE", "onStartCommand: Inside the on StartCommand of ServiceClass.")

        return START_STICKY
    }
    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}