package com.tmdb.mymovies.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
    @field:PrimaryKey var id: Int,
    var title: String,
    var description: String,
    var imageUrl: String)