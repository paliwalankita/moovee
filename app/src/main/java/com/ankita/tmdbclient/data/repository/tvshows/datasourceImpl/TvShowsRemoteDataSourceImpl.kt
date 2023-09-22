package com.ankita.tmdbclient.data.repository.tvshows.datasourceImpl

import com.ankita.tmdbclient.data.api.TMDBService
import com.ankita.tmdbclient.data.model.tvshows.TvShowList
import com.ankita.tmdbclient.data.repository.tvshows.datasource.TvShowsRemoteDataSource
import retrofit2.Response

class TvShowsRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String): TvShowsRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}