package com.ankita.tmdbclient.data.repository.movies.datasource

import com.ankita.tmdbclient.data.model.movies.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}