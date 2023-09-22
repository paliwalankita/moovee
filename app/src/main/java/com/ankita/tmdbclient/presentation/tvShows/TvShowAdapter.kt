package com.ankita.tmdbclient.presentation.tvShows

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ankita.tmdbclient.R
import com.ankita.tmdbclient.data.model.movies.Movie
import com.ankita.tmdbclient.data.model.tvshows.TvShow
import com.ankita.tmdbclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class TvShowAdapter: RecyclerView.Adapter<TvShowViewHolder>() {
    private val tvShowList = ArrayList<TvShow>()
    fun setList(tvShows: List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.list_item,
            parent,
            false)

        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class TvShowViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(tvShow: TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterURL = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }
}