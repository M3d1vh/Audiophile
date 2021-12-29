package com.example.audiophile.model

import kotlinx.serialization.Serializable

@Serializable
data class Headphone(
    val product: Product,
    val description: String
)

