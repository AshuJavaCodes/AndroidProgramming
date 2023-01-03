package com.redeyesncode.androidservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.redeyesncode.androidservices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Mainly in android there are three kinds of services which  are described below
        /*  1. Foreground Service 2. Background Service 3. Bounded Service                */


        // In the below lines we are stopping and starting the service.
        binding.btnStartService.setOnClickListener {

            startService(Intent(this,MyAndroidService::class.java))
        }

        binding.btnStopService.setOnClickListener {
            stopService(Intent(this,MyAndroidService::class.java))

        }

    }
}