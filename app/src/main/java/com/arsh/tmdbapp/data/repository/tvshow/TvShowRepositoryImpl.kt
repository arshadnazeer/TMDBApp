package com.arsh.tmdbapp.data.repository.tvshow

import android.util.Log
import com.arsh.tmdbapp.data.model.tvshows.TvShow
import com.arsh.tmdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.arsh.tmdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.arsh.tmdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.arsh.tmdbapp.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowCacheDataSource: TvShowCacheDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowRemoteDataSource: TvShowRemoteDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShow = getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShow)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShow)
        return newListOfTvShow
    }

    suspend fun getTvShowsFromApi():List<TvShow>{
        lateinit var tvShowList : List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body!=null){
                tvShowList = body.tvShows
            }
        }catch (e: Exception){
            Log.e("TAGGG",e.message.toString())
        }

        return tvShowList
    }


    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()

        }catch (e: Exception){
            Log.e("TAGGG",e.message.toString())
        }

        if (tvShowList.size>0){
            return tvShowList
        }else
            tvShowList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)

        return tvShowList
    }

    suspend fun getTvShowsFromCache() : List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()

        }catch (e:Exception){
            Log.e("TAGGG",e.message.toString())
        }

        if (tvShowList.size>0){
            return tvShowList
        }else
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)

        return tvShowList
    }
}