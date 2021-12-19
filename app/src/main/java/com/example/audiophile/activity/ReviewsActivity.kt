package com.example.audiophile.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.audiophile.R
import com.example.audiophile.adapter.ReviewAdapter
import com.example.audiophile.adapter.ShopAdapter
import com.example.audiophile.data.DataSource

class ReviewsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reviews)
        val rvReview = findViewById<RecyclerView>(R.id.rvReview)
        rvReview.layoutManager = LinearLayoutManager(this)
        rvReview.adapter = ReviewAdapter(DataSource.Reviews) {}
    }
}