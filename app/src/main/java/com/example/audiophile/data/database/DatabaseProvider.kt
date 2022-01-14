package com.example.audiophile.data.database

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    private var db: HeadphonesDatabase? = null

    fun provideDatabase(context: Context): HeadphonesDatabase {
        return db ?: Room.databaseBuilder(
            context.applicationContext,
            HeadphonesDatabase::class.java, "headphones_app_database"
        )
            .build()
            .also{ db = it }
    }
}