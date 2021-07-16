package com.arsh.tmdbapp.data.repository.movie.datasource

import com.arsh.tmdbapp.data.model.movies.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movie:List<Movie>)

}