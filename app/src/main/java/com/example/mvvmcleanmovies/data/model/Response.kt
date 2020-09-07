package com.example.mvvmcleanmovies.data.model

class Response<T>(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<T>
)