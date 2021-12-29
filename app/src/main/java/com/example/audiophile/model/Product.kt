package com.example.audiophile.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val iconURL: String,
    val nameModel : String,
)
