package com.tmdb.mymovies.model

import com.tmdb.mymovies.data.Movie
import javax.inject.Inject
import com.tmdb.mymovies.model.datasource.LocalDataSource
import com.tmdb.mymovies.model.datasource.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getPopularMovies(): List<Movie> = withContext(Dispatchers.IO) {
        remoteDataSource.getPopularMovies()
    }
}