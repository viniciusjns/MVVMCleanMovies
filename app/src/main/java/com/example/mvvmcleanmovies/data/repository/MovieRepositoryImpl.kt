package com.example.mvvmcleanmovies.data.repository

import com.example.mvvmcleanmovies.data.mapper.toMovieMapper
import com.example.mvvmcleanmovies.data.service.MovieService
import com.example.mvvmcleanmovies.domain.model.Movie
import com.example.mvvmcleanmovies.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieService: MovieService
) : MovieRepository {

    override suspend fun getPopularMovies(): List<Movie> =
        movieService.getPopularMovies().results.map {
            it.toMovieMapper()
        }
}