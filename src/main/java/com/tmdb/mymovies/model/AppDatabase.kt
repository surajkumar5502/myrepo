package com.tmdb.mymovies.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tmdb.mymovies.data.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}