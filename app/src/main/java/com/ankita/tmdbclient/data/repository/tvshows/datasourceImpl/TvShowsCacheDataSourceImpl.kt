package com.ankita.tmdbclient.data.repository.tvshows.datasourceImpl

import com.ankita.tmdbclient.data.model.tvshows.TvShow
import com.ankita.tmdbclient.data.repository.tvshows.datasource.TvShowsCacheDataSource

class TvShowsCacheDataSourceImpl: TvShowsCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}