package com.arsh.tmdbapp.presentation.di.core

import com.arsh.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.arsh.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.arsh.tmdbapp.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.arsh.tmdbapp.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.arsh.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import com.arsh.tmdbapp.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.arsh.tmdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.arsh.tmdbapp.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource():TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }
}