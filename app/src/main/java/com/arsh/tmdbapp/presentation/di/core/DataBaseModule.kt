package com.arsh.tmdbapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.arsh.tmdbapp.data.db.ArtistDAO
import com.arsh.tmdbapp.data.db.MovieDAO
import com.arsh.tmdbapp.data.db.TMDBDatabase
import com.arsh.tmdbapp.data.db.TvShowDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java,"TMDBDatabase")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDAO(tmdbDatabase: TMDBDatabase): MovieDAO {
        return tmdbDatabase.movieDao()
    }

    @Provides
    fun provideTvShowDAO(tmdbDatabase: TMDBDatabase): TvShowDAO {
        return tmdbDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDAO(tmdbDatabase: TMDBDatabase): ArtistDAO {
        return tmdbDatabase.artistDao()
    }

}
