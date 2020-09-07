package com.example.mvvmcleanmovies.domain.usecase

import com.example.mvvmcleanmovies.domain.model.Movie
import com.example.mvvmcleanmovies.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieUseCaseImpl(
    private val movieRepository: MovieRepository
): MovieUseCase {

    override suspend fun getPopularMovies(): List<Movie> =
        withContext(Dispatchers.IO) {
            movieRepository.getPopularMovies()
        }
}