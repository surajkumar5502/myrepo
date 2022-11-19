package com.tmdb.mymovies.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.tmdb.mymovies.util.ImageLoadingUtils
import androidx.recyclerview.widget.RecyclerView
import com.tmdb.mymovies.R
import com.tmdb.mymovies.data.Movie
import com.tmdb.mymovies.view.adapter.MovieListAdapter.MovieViewHolder

class MovieListAdapter : RecyclerView.Adapter<MovieViewHolder>() {
    private var movieList: List<Movie>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = View.inflate(parent.context, R.layout.movie_list_item, null)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val context = holder.itemView.context
        val movie = movieList!![position]
        holder.mTitle.text = movie.title
        ImageLoadingUtils.loadImage(context, movie.imageUrl, holder.mPoster)
        holder.mBookmarkButton.setOnClickListener { v: View? -> }
    }

    override fun getItemCount(): Int {
        return if (movieList == null) 0 else movieList!!.size
    }

    fun notifyDataSetChanged(movieList: List<Movie>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mPoster: ImageView
        var mTitle: TextView
        var mBookmarkButton: ImageButton

        init {
            mPoster = itemView.findViewById(R.id.movie_poster)
            mTitle = itemView.findViewById(R.id.movie_title)
            mBookmarkButton = itemView.findViewById(R.id.add_to_playlist_button)
        }
    }
}