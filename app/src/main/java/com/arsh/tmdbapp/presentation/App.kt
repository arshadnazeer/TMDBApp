package com.arsh.tmdbapp.presentation

import android.app.Application
import com.arsh.tmdbapp.BuildConfig
import com.arsh.tmdbapp.presentation.di.Injector
import com.arsh.tmdbapp.presentation.di.artist.ArtistSubComponent
import com.arsh.tmdbapp.presentation.di.core.*
import com.arsh.tmdbapp.presentation.di.movie.MovieSubComponent
import com.arsh.tmdbapp.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }


    override fun createMovieSubcomponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubcomponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubcomponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}