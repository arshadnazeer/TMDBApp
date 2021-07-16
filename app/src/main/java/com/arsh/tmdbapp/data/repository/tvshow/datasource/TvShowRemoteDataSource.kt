package com.arsh.tmdbapp.data.repository.tvshow.datasource

import com.arsh.tmdbapp.data.model.tvshows.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows():Response<TvShowList>
}