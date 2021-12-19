package com.example.audiophile.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.audiophile.R
import com.example.audiophile.adapter.HeadphoneAdapter
import com.example.audiophile.adapter.ReviewAdapter
import com.example.audiophile.adapter.ShopAdapter
import com.example.audiophile.data.DataSource

class ShopsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shops)
        val rvShops = findViewById<RecyclerView>(R.id.rvShops)
        rvShops.layoutManager = LinearLayoutManager(this)
        rvShops.adapter = ShopAdapter(DataSource.Shops) {}
    }
}
