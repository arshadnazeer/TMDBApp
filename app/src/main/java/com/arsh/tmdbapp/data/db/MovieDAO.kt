package com.arsh.tmdbapp.data.db

import androidx.room.*
import com.arsh.tmdbapp.data.model.movies.Movie

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)  // Room will replace the old data and continue the transaction
    suspend fun saveMovies (movies: List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies(): List<Movie>

}