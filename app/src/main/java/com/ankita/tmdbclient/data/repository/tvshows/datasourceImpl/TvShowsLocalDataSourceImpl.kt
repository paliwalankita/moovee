package com.ankita.tmdbclient.data.repository.tvshows.datasourceImpl

import com.ankita.tmdbclient.data.db.TvShowsDao
import com.ankita.tmdbclient.data.model.tvshows.TvShow
import com.ankita.tmdbclient.data.repository.tvshows.datasource.TvShowsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowsLocalDataSourceImpl(private val tvShowsDao: TvShowsDao): TvShowsLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowsDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.deleteAllTvShows()
        }
    }
}