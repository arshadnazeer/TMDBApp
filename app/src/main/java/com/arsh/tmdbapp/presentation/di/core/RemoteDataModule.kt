package com.arsh.tmdbapp.presentation.di.core

import com.arsh.tmdbapp.data.api.TMDBService
import com.arsh.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.arsh.tmdbapp.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.arsh.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.arsh.tmdbapp.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.arsh.tmdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.arsh.tmdbapp.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apikey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService,apikey)
    }


    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService):TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(tmdbService,apikey)
    }


    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(tmdbService,apikey)
    }
}