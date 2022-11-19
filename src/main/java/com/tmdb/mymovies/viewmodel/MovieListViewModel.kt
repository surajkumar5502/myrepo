package com.tmdb.mymovies.viewmodel

import javax.inject.Inject
import com.tmdb.mymovies.model.MovieRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tmdb.mymovies.data.Movie
import com.tmdb.mymovies.data.State
import kotlinx.coroutines.*

class MovieListViewModel @Inject constructor(private val movieRepo: MovieRepository) : ViewModel() {
    private val _state = MutableLiveData<State>()
    var state: LiveData<State> = _state
    private val _popularMovies = MutableLiveData<List<Movie>>()

    @JvmField
    var popularMovies: LiveData<List<Movie>> = _popularMovies

    fun fetchMovies() {
        viewModelScope.launch {
            try {
                val movies = movieRepo.getPopularMovies()
                _state.postValue(State.NORMAL)
                _popularMovies.postValue(movies)
            } catch (e: Exception) {
                _state.value = State.ERROR
            }
        }
    }
}