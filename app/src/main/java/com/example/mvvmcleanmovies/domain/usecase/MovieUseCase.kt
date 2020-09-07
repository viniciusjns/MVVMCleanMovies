package com.example.mvvmcleanmovies.domain.usecase

import com.example.mvvmcleanmovies.domain.model.Movie

interface MovieUseCase {

    suspend fun getPopularMovies(): List<Movie>
}