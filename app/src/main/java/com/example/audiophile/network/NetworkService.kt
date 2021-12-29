package com.example.audiophile.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object NetworkService {
    @ExperimentalSerializationApi
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://demo5130816.mockable.io/")
        .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
        .build()
    @ExperimentalSerializationApi
    private val restApi = retrofit.create(RestApi::class.java)

    @ExperimentalSerializationApi
    suspend fun loadHeadphones() = restApi.loadHeadphones()
    @ExperimentalSerializationApi
    suspend fun loadReviews() = restApi.loadReviews()
    @ExperimentalSerializationApi
    suspend fun loadStores() = restApi.loadStores()
}