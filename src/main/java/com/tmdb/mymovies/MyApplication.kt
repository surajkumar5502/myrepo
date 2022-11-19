package com.tmdb.mymovies

import android.app.Application
import com.tmdb.mymovies.di.AppModule
import com.tmdb.mymovies.di.ApplicationComponent
import com.tmdb.mymovies.di.DaggerApplicationComponent

class MyApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}