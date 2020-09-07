package com.example.mvvmcleanmovies.data.repository

import com.example.mvvmcleanmovies.domain.model.Movie

interface MovieRepository {

    suspend fun getPopularMovies(): List<Movie>
}