package com.example.mvvmcleanmovies.data.service

import com.example.mvvmcleanmovies.data.model.MovieResponse
import com.example.mvvmcleanmovies.data.model.Response
import retrofit2.http.GET

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<MovieResponse>

}