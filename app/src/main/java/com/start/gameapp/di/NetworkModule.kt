package com.start.gameapp.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { getOkHttpClient() }
    single { getRetrofit(get()) }
}

fun getRetrofit(okHttpClient: OkHttpClient) : Retrofit{
    return Retrofit.Builder()
        .baseUrl("http://staging.domain.com")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(okHttpClient)
        .build()
}

fun getOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
            .followRedirects(true)
            .followSslRedirects(true)
            .retryOnConnectionFailure(true)
            .cache(null)
            .addInterceptor(interceptor)
//            .addInterceptor {
//                val requestBuilder = it.request().newBuilder()
//                        .addHeader("Authorization", "Bearer ${EmployeeConstant.TOKEN}")
//                it.proceed(requestBuilder.build())
//            }
            .connectTimeout(400, TimeUnit.SECONDS)
            .writeTimeout(400, TimeUnit.SECONDS)
            .readTimeout(400, TimeUnit.SECONDS)
            .build()
}