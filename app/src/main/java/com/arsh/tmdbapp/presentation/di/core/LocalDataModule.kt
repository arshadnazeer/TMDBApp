package com.arsh.tmdbapp.presentation.di.core

import com.arsh.tmdbapp.data.db.ArtistDAO
import com.arsh.tmdbapp.data.db.MovieDAO
import com.arsh.tmdbapp.data.db.TvShowDAO
import com.arsh.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.arsh.tmdbapp.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.arsh.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.arsh.tmdbapp.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.arsh.tmdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.arsh.tmdbapp.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    // we need to add dao interface as function parameter
    // we have already created the database moduule to provide DAO Dependencies
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDAO)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDAO: TvShowDAO): TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDAO)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDAO: ArtistDAO): ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDAO)
    }

}