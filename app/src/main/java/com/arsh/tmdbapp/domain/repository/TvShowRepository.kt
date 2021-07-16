package com.arsh.tmdbapp.domain.repository

import com.arsh.tmdbapp.data.model.tvshows.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}