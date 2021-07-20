package com.arsh.tmdbapp.data.repository.artist

import android.util.Log
import com.arsh.tmdbapp.data.model.artists.Artist
import com.arsh.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.arsh.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.arsh.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.arsh.tmdbapp.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistCacheDataSource: ArtistCacheDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource
) : ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListOfArtist = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListOfArtist)
        artistCacheDataSource.saveArtistToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistFromAPI():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if (body!=null){
                artistList = body.artists
            }

        }catch (e:Exception){
            Log.e("TAGGG",e.message.toString())
        }

        return artistList
    }


    suspend fun getArtistFromDB():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromFromDB()

        }catch (e:Exception){
            Log.e("TAGGG",e.message.toString())
        }

        if (artistList.size>0){
            return artistList
        }else
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtistToDB(artistList)

        return artistList
    }


    suspend fun getArtistFromCache():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistFromCache()

        }catch (e:Exception){
            Log.e("TAGGG",e.message.toString())
        }

        if (artistList.size>0){
            return artistList
        }else
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)

        return artistList
    }
}