package com.ankita.tmdbclient.presentation.tvShows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ankita.tmdbclient.R
import com.ankita.tmdbclient.databinding.ActivityTvShowsBinding
import com.ankita.tmdbclient.presentation.di.Injector
import com.ankita.tmdbclient.presentation.movie.MovieAdapter
import com.ankita.tmdbclient.presentation.movie.MovieViewModel
import com.ankita.tmdbclient.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class TvShowsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter
    private lateinit var binding: ActivityTvShowsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_shows)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this, factory).get(TvShowViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvShowRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if(it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }else{
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available!!", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update -> {
                updateTvShows()
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTvShows()
        response.observe(this, Observer {
            if(it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }else{
                binding.tvShowProgressBar.visibility = View.GONE
            }
        })
    }
}