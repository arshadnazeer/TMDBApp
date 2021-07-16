package com.arsh.tmdbapp.presentation.di.core

import android.content.Context
import com.arsh.tmdbapp.presentation.di.artist.ArtistSubComponent
import com.arsh.tmdbapp.presentation.di.movie.MovieSubComponent
import com.arsh.tmdbapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

// provides application constext dependency
@Module(subcomponents = [MovieSubComponent::class,TvShowSubComponent::class,ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}