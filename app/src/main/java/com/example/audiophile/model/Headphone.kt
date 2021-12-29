package com.example.audiophile.model

import kotlinx.serialization.Serializable

@Serializable
data class Headphone(
    val model: Product,
    val description: String
)

