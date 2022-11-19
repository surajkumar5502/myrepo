package com.tmdb.mymovies.view.activity

import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject
import com.tmdb.mymovies.di.DaggerViewModelFactory
import com.tmdb.mymovies.viewmodel.MovieListViewModel
import com.tmdb.mymovies.view.adapter.MovieListAdapter
import android.os.Bundle
import com.tmdb.mymovies.MyApplication
import androidx.lifecycle.ViewModelProvider
import androidx.databinding.DataBindingUtil
import com.tmdb.mymovies.R
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.tmdb.mymovies.data.Movie
import com.tmdb.mymovies.databinding.MovieListActivityBinding

class MovieListActivity : AppCompatActivity() {
    @Inject
    var viewModelFactory: DaggerViewModelFactory? = null
    private lateinit var binding: MovieListActivityBinding
    private lateinit var viewModel: MovieListViewModel
    private var popularMoviesAdapter: MovieListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as MyApplication).applicationComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory!!).get(MovieListViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.movie_list_activity)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        initView()
        initViewModel()
    }

    private fun initView() {
        binding.retryButton.setOnClickListener { view: View? -> viewModel.fetchMovies() }
        binding.popularMoviesList.layoutManager = GridLayoutManager(this, 1)
        popularMoviesAdapter = MovieListAdapter()
        binding.popularMoviesList.adapter = popularMoviesAdapter
    }

    private fun initViewModel() {
        viewModel.fetchMovies()
        viewModel.popularMovies.observe(this) { movieList: List<Movie> ->
            popularMoviesAdapter?.notifyDataSetChanged(movieList)
        }
    }
}