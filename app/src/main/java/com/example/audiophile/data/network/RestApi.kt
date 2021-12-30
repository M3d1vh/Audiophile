package com.example.audiophile.data.network

import com.example.audiophile.domain.model.Headphone
import com.example.audiophile.domain.model.Review
import com.example.audiophile.domain.model.Stores
import retrofit2.http.GET

interface RestApi {
    @GET("headphones")
    suspend fun loadHeadphones(): List<Headphone>
    @GET("reviews")
    suspend fun loadReviews(): List<Review>
    @GET("stores")
    suspend fun loadStores(): List<Stores>
}