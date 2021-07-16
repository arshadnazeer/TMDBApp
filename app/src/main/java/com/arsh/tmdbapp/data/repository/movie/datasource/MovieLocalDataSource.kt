package com.arsh.tmdbapp.data.repository.movie.datasource

import com.arsh.tmdbapp.data.model.movies.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movie: List<Movie>)
    suspend fun clearAll()
}