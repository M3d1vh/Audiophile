package com.example.audiophile.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.audiophile.domain.model.Headphone

@Dao
interface HeadphoneDao {
    @Query("SELECT * FROM headphone")
    suspend fun getAll(): List<Headphone>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(headphones: List<Headphone>)
}