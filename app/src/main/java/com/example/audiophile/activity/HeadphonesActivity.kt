package com.example.audiophile.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.audiophile.R
import com.example.audiophile.adapter.HeadphoneAdapter
import com.example.audiophile.data.DataSource

class HeadphonesActivity : Activity() {
    companion object{
        const val KEY_NAME = "name"
        const val KEY_DESCRIPTION = "description"
        const val KEY_ICON_RES_ID = "iconResId"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_headphones)
        val rvHeadphone = findViewById<RecyclerView>(R.id.rvHeadphones)
        rvHeadphone.layoutManager = LinearLayoutManager(this)
        rvHeadphone.adapter = HeadphoneAdapter(DataSource.Headphones) { (model, description, iconResId) ->
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra(KEY_NAME, model)
            intent.putExtra(KEY_DESCRIPTION, description)
            intent.putExtra(KEY_ICON_RES_ID, iconResId)
            startActivity(intent)
        }
    }
}