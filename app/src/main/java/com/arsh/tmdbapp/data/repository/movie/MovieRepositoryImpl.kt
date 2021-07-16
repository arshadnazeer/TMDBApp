package com.arsh.tmdbapp.data.repository.movie

import android.util.Log
import com.arsh.tmdbapp.data.model.movies.Movie
import com.arsh.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import com.arsh.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.arsh.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.arsh.tmdbapp.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovie = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovie)
        movieCacheDataSource.saveMoviesToCache(newListOfMovie)
        return newListOfMovie
    }

    suspend fun getMoviesFromAPI(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body!=null){
                movieList = body.movies
            }
        }catch (e: Exception){
            Log.e("TAGGG",e.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList: List<Movie>
        try {
           movieList = movieLocalDataSource.getMoviesFromDB()

        }catch (e: Exception){
            Log.e("TAGGG",e.message.toString())
        }

        if (movieList.size>0){
            return movieList
        }else
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)

        return movieList
    }


    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()

        }catch (e: Exception){
            Log.e("TAGGG",e.message.toString())
        }

        if (movieList.size>0){
            return movieList
        }else
            movieList = getMoviesFromDB()
        movieCacheDataSource.saveMoviesToCache(movieList)

        return movieList
    }
}

