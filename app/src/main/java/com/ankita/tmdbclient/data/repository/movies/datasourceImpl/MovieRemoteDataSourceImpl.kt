package com.ankita.tmdbclient.data.repository.movies.datasourceImpl

import com.ankita.tmdbclient.data.api.TMDBService
import com.ankita.tmdbclient.data.model.movies.MovieList
import com.ankita.tmdbclient.data.repository.movies.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String)
    : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
    }

