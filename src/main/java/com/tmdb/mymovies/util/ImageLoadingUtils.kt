package com.tmdb.mymovies.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageLoadingUtils {
    private const val BASE_PATH = "https://image.tmdb.org/t/p/original/"
    fun loadImage(context: Context?, url: String, imageView: ImageView?) {
        Glide.with(context!!)
            .load(BASE_PATH + url)
            .into(imageView!!)
    }
}