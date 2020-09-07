package com.example.mvvmcleanmovies.data.service

import com.example.mvvmcleanmovies.domain.model.Movie
import com.example.mvvmcleanmovies.data.model.Response
import retrofit2.http.GET

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<Movie>

}