package com.example.audiophile.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val model : String,
    val iconUrl: String
)
