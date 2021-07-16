package com.arsh.tmdbapp.data.repository.movie.datasourceimpl

import com.arsh.tmdbapp.data.db.MovieDAO
import com.arsh.tmdbapp.data.model.movies.Movie
import com.arsh.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDAO: MovieDAO) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDAO.getMovies()
    }

    override suspend fun saveMoviesToDB(movie: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movie)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }
    }
}