package com.example.audiophile.network

import com.example.audiophile.model.Headphone
import com.example.audiophile.model.Review
import com.example.audiophile.model.Stores
import retrofit2.http.GET

interface RestApi {
    @GET("headphones")
    suspend fun loadHeadphones(): List<Headphone>
    @GET("reviews")
    suspend fun loadReviews(): List<Review>
    @GET("stores")
    suspend fun loadStores(): List<Stores>
}