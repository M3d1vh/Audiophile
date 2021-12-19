package com.example.audiophile.activity

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.audiophile.R

class SplashActivity: Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)
    }

}
