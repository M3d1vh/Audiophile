package com.example.audiophile.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Stores(
    val iconShopURL: String,
    val nameShop: String,
    val website: String,
    val price : String,
    val available : String,
    val delivery : String
)
