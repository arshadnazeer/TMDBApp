package com.arsh.tmdbapp.data.repository.tvshow.datasourceimpl

import com.arsh.tmdbapp.data.db.TvShowDAO
import com.arsh.tmdbapp.data.model.tvshows.TvShow
import com.arsh.tmdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDAO: TvShowDAO) : TvShowLocalDataSource {

    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDAO.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShow: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.saveTvShows(tvShow)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.deleteAllTvShows()
        }
    }
}