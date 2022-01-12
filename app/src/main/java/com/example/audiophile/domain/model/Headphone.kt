package com.example.audiophile.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
@Entity(primaryKeys = ["model", "iconUrl", "description"])
data class Headphone(
    @ColumnInfo val model : String,
    @ColumnInfo val iconUrl: String,
    @ColumnInfo val description: String,
)

