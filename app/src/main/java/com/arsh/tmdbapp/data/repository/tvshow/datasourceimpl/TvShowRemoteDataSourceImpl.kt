package com.arsh.tmdbapp.data.repository.tvshow.datasourceimpl

import com.arsh.tmdbapp.data.api.TMDBService
import com.arsh.tmdbapp.data.model.tvshows.TvShow
import com.arsh.tmdbapp.data.model.tvshows.TvShowList
import com.arsh.tmdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ) : TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}