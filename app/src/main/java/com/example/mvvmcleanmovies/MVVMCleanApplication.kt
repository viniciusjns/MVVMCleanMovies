package com.example.mvvmcleanmovies

import android.app.Application
import com.example.mvvmcleanmovies.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MVVMCleanApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@MVVMCleanApplication)
            androidLogger()
            modules(listOf(vieModelModule, useCaseModule, repositoryModule, networkModule))
        }
    }
}