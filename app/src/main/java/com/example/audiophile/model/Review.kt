package com.example.audiophile.model

import kotlinx.serialization.Serializable

@Serializable
data class Review (
    val User : User,
    val date: String,
    val useTime: String,
    val dignity: String,
    val limits: String,
    val comment: String
)
