package com.tmdb.mymovies.model

import com.tmdb.mymovies.data.MovieListResponse
import retrofit2.http.GET
import com.tmdb.mymovies.util.Constants

interface ApiService {
    @GET("movie/popular?api_key=" + Constants.API_KEY)
    suspend fun getPopularMovies(): MovieListResponse
}