package com.example.audiophile.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.audiophile.domain.model.Headphone

@Database(
    entities = [Headphone::class],
    version = 1
)
abstract class HeadphonesDatabase : RoomDatabase() {
    abstract fun hpDao(): HeadphoneDao
}