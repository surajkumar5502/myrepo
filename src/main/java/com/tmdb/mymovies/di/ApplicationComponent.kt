package com.tmdb.mymovies.di

import javax.inject.Singleton
import com.tmdb.mymovies.view.activity.MovieListActivity
import dagger.*

@Singleton
@Component(modules = [ViewModelModule::class, AppModule::class])
interface ApplicationComponent {
    fun inject(movieListActivity: MovieListActivity?)
}