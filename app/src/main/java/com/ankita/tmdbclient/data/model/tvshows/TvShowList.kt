package com.ankita.tmdbclient.data.model.tvshows


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>
)