package com.example.mvvmcleanmovies.domain.mapper

import com.example.mvvmcleanmovies.domain.model.Movie
import com.example.mvvmcleanmovies.presentation.models.MovieUiModel

fun Movie.toMovieUiModel() =
    MovieUiModel(
        id = this.id,
        title = this.title,
        releaseDate = this.releaseDate,
        poster = this.poster
    )