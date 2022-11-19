package com.tmdb.mymovies.model.datasource

import com.tmdb.mymovies.model.ApiService
import com.tmdb.mymovies.data.MovieListResponse
import com.tmdb.mymovies.data.Movie
import java.util.ArrayList

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getPopularMovies(): List<Movie> {
        val movies: MutableList<Movie> = ArrayList()
        apiService.getPopularMovies().let { response: MovieListResponse ->
            for (i in response.results!!.indices) {
                val result = response.results!![i]
                movies.add(
                    Movie(
                        result.id,
                        result.title!!,
                        result.overview!!,
                        result.poster_path!!
                    )
                )
            }
        }
        return movies
    }
}