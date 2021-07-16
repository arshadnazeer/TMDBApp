package com.arsh.tmdbapp.data.repository.tvshow.datasource

import com.arsh.tmdbapp.data.model.tvshows.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(tvShow: List<TvShow>)
    suspend fun clearAll()
}