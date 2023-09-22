package com.ankita.tmdbclient.presentation.di.tvShow

import com.ankita.tmdbclient.presentation.tvShows.TvShowsActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowsActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}