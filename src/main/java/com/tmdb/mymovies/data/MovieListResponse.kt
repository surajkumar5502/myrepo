package com.tmdb.mymovies.data

import java.util.ArrayList

class MovieListResponse {
    var page = 0
    @JvmField
    var results: ArrayList<Result>? = null
    var total_pages = 0
    var total_results = 0

    class Result {
        var adult = false
        var backdrop_path: String? = null
        var genre_ids: ArrayList<Int>? = null
        @JvmField
        var id = 0
        var original_language: String? = null
        var original_title: String? = null
        @JvmField
        var overview: String? = null
        var popularity = 0.0
        @JvmField
        var poster_path: String? = null
        var release_date: String? = null
        @JvmField
        var title: String? = null
        var video = false
        var vote_average = 0.0
        var vote_count = 0
    }
}