package com.example.audiophile.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Headphone(
    val product: Product,
    val description: String
)

