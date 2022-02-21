package com.example.mvvmcleanmovies.di

object ModuleProvider {
    val modules = listOf(
        dataModule,
        domainModule,
        presentationModule
    )
}