package com.ankita.tmdbclient.domain.repository

import com.ankita.tmdbclient.data.model.movies.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}