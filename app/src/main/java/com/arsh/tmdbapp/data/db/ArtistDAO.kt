package com.arsh.tmdbapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arsh.tmdbapp.data.model.artists.Artist
import com.arsh.tmdbapp.data.model.tvshows.TvShow

@Dao
interface ArtistDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artist : List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtist()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtist(): List<Artist>
}