package com.example.audiophile.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name : String,
    val lastname : String,

)
