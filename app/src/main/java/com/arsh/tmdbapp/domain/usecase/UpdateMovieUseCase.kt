package com.arsh.tmdbapp.domain.usecase

import com.arsh.tmdbapp.data.model.movies.Movie
import com.arsh.tmdbapp.domain.repository.MovieRepository

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}