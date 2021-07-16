package com.arsh.tmdbapp.presentation.di.core

import com.arsh.tmdbapp.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule (private val baseURL: String){
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseURL)
            .build()
    }

    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit): TMDBService{
        return retrofit.create(TMDBService::class.java)
    }
}