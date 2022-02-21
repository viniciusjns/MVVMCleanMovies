package com.example.mvvmcleanmovies.data.mapper

import com.example.mvvmcleanmovies.data.model.MovieResponse
import com.example.mvvmcleanmovies.domain.model.Movie

fun MovieResponse.toMovieMapper() =
    Movie(
        id = this.id,
        title = this.title,
        releaseDate = this.release_date,
        poster = this.getPoster()
    )