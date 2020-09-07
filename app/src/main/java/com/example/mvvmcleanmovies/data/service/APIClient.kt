package com.example.mvvmcleanmovies.data.service

import retrofit2.Retrofit

interface APIClient {
    fun configure(baseUrl: String): Retrofit
}