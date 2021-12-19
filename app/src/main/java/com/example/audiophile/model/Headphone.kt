package com.example.audiophile.model

import androidx.annotation.DrawableRes

data class Headphone(
    @DrawableRes val im_modelID: Int,
    val model: String,
    val description: String
)

