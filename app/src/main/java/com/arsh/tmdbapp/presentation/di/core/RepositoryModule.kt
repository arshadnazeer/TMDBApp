package com.arsh.tmdbapp.presentation.di.core

import com.arsh.tmdbapp.data.repository.artist.ArtistRepositoryImpl
import com.arsh.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.arsh.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.arsh.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.arsh.tmdbapp.data.repository.movie.MovieRepositoryImpl
import com.arsh.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import com.arsh.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.arsh.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.arsh.tmdbapp.data.repository.tvshow.TvShowRepositoryImpl
import com.arsh.tmdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.arsh.tmdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.arsh.tmdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.arsh.tmdbapp.domain.repository.ArtistRepository
import com.arsh.tmdbapp.domain.repository.MovieRepository
import com.arsh.tmdbapp.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ):MovieRepository{
        return MovieRepositoryImpl(movieRemoteDataSource,movieLocalDataSource,movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ):TvShowRepository{
        return TvShowRepositoryImpl(tvShowCacheDataSource,tvShowLocalDataSource,tvShowRemoteDataSource)
    }


    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistCacheDataSource: ArtistCacheDataSource,
        artistLocalDataSource: ArtistLocalDataSource
    ):ArtistRepository{
        return ArtistRepositoryImpl(artistCacheDataSource,artistRemoteDataSource,artistLocalDataSource)
    }


}