package com.ankita.tmdbclient.data.repository.tvshows

import android.util.Log
import com.ankita.tmdbclient.data.model.tvshows.TvShow
import com.ankita.tmdbclient.data.repository.tvshows.datasource.TvShowsCacheDataSource
import com.ankita.tmdbclient.data.repository.tvshows.datasource.TvShowsLocalDataSource
import com.ankita.tmdbclient.data.repository.tvshows.datasource.TvShowsRemoteDataSource
import com.ankita.tmdbclient.domain.repository.TvShowsRepository

class TvShowsRepositoryImpl(
    private val tvShowsRemoteDataSource: TvShowsRemoteDataSource,
    private val tvShowsLocalDataSource: TvShowsLocalDataSource,
    private val tvShowsCacheDataSource: TvShowsCacheDataSource,
    ): TvShowsRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromApi()
        tvShowsLocalDataSource.clearAll()
        tvShowsLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowsCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromApi(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try{
            val response = tvShowsRemoteDataSource.getTvShows()
            val body = response.body()
            if(body != null){
                tvShowList = body.tvShows
            }
        }catch(exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try{
            tvShowList = tvShowsLocalDataSource.getTvShowsFromDB()
        }catch(exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if(tvShowList.isNotEmpty()){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromApi()
            tvShowsLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try{
            tvShowList = tvShowsCacheDataSource.getTvShowsFromCache()
        }catch(exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if(tvShowList.isNotEmpty()){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromDB()
            tvShowsCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }
}