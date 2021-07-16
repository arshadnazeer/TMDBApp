package com.arsh.tmdbapp.data.repository.tvshow.datasourceimpl

import com.arsh.tmdbapp.data.model.tvshows.TvShow
import com.arsh.tmdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShow: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShow)
    }
}