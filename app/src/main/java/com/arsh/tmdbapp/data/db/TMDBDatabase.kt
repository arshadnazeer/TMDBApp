package com.arsh.tmdbapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arsh.tmdbapp.data.model.artists.Artist
import com.arsh.tmdbapp.data.model.movies.Movie
import com.arsh.tmdbapp.data.model.tvshows.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class],
version = 1, exportSchema = false)

abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDAO
    abstract fun tvShowDao(): TvShowDAO
    abstract fun artistDao(): ArtistDAO

}