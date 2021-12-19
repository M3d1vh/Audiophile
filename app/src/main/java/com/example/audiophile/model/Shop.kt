package com.example.audiophile.model

import androidx.annotation.DrawableRes

data class Shop(
    @DrawableRes val im_shopID:Int,
    val shopName : String,
    val price : String,
    val available : String,
    val delivery : String
)
