package com.arsh.tmdbapp.data.repository.movie.datasourceimpl

import com.arsh.tmdbapp.data.model.movies.Movie
import com.arsh.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movie: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movie)
    }
}