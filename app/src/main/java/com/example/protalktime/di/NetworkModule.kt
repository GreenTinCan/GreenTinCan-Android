package com.example.protalktime.di

import com.example.protalktime.data.network.NetworkInterceptor
import com.example.protalktime.data.network.api.TestApi
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import com.example.protalktime.BuildConfig
import com.example.protalktime.data.network.api.MatchingApi
import com.example.protalktime.data.network.api.profile.ProfileApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .addNetworkInterceptor(NetworkInterceptor())
            .addInterceptor(Interceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder().build()
                )
            })
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(get())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    single<TestApi> {
        get<Retrofit>().create(TestApi::class.java)
    }

    single<MatchingApi> {
        get<Retrofit>().create(MatchingApi::class.java)
    }
    single<ProfileApi> {
        get<Retrofit>().create(ProfileApi::class.java)
    }
}