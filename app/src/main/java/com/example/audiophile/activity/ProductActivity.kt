package com.example.audiophile.activity

import android.app.Activity
import android.os.Bundle
import com.example.audiophile.R

class ProductActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_headphone_product)
    }
}