package com.ankita.tmdbclient.data.repository.tvshows.datasource

import com.ankita.tmdbclient.data.model.tvshows.TvShowList
import retrofit2.Response

interface TvShowsRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}