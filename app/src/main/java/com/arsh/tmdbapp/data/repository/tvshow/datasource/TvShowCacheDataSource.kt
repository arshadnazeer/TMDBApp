package com.arsh.tmdbapp.data.repository.tvshow.datasource

import com.arsh.tmdbapp.data.model.tvshows.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache():List<TvShow>
    suspend fun saveTvShowToCache(tvShow: List<TvShow>)
}