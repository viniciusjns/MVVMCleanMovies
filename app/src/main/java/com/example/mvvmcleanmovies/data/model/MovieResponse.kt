package com.example.mvvmcleanmovies.data.model

data class MovieResponse(
    val popularity: Float,
    val id: Int,
    val video: Boolean,
    val vote_count: Int,
    val vote_average: Double,
    val title: String,
    val release_date: String,
    val original_language: String,
    val original_title: String,
    val backdrop_path: String,
    val adult: Boolean,
    val overview: String,
    val poster_path: String
) {
    fun getPoster(): String =
        "https://image.tmdb.org/t/p/w500/$poster_path"
}