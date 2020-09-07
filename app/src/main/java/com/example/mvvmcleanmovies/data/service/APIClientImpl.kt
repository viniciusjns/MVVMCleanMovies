package com.example.mvvmcleanmovies.data.service

import com.example.mvvmcleanmovies.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIClientImpl : APIClient {

    companion object {
        private const val TIMEOUT = 360

        lateinit var instance: APIClient
    }

    private val requestIntercept = { chain: Interceptor.Chain ->

        val original = chain.request()
        val originalHttpUrl = original.url
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key",
                BuildConfig.API_KEY
            )
            .addQueryParameter("language", "pt-BR")
            .addQueryParameter("limit", "100")
            .build()

        val requestBuilder = original.newBuilder().url(url)
        val request = requestBuilder.build()

        chain.proceed(request)
    }

    private val client: OkHttpClient
        get() {
            val okHttp = OkHttpClient().newBuilder()
                .addInterceptor(requestIntercept)
                .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            okHttp.addInterceptor(loggingCapableHttpClient)

            return okHttp.build()
        }

    private val loggingCapableHttpClient: HttpLoggingInterceptor
        get() {
            val mLogging = HttpLoggingInterceptor()
            mLogging.level = HttpLoggingInterceptor.Level.BODY

            return mLogging
        }

    init {
        instance = this
    }

    override fun configure(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

}