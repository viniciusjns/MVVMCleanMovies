package com.example.mvvmcleanmovies.domain.usecase

import com.example.mvvmcleanmovies.domain.model.Movie
import com.example.mvvmcleanmovies.domain.repository.MovieRepository

class MovieUseCaseImpl(
    private val movieRepository: MovieRepository
): MovieUseCase {

    override suspend fun getPopularMovies(): List<Movie> =
        movieRepository.getPopularMovies()
}