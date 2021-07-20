package com.arsh.tmdbapp.presentation.tvshow

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
import com.arsh.tmdbapp.R
import com.arsh.tmdbapp.databinding.ActivityMovieBinding
import com.arsh.tmdbapp.databinding.ActivityTvShowBinding
import com.arsh.tmdbapp.presentation.di.Injector
import com.arsh.tmdbapp.presentation.movie.MovieAdapter
import com.arsh.tmdbapp.presentation.movie.MovieViewModel
import com.arsh.tmdbapp.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var tvShowViewModelFactory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var adapter: TvAdapter
    private lateinit var tvShowBinding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvShowBinding = DataBindingUtil.setContentView(this,R.layout.activity_tv_show)
        (application as Injector).createTvShowSubcomponent()
            .inject(this)

        tvShowViewModel= ViewModelProvider(this,tvShowViewModelFactory).get(TvShowViewModel::class.java)
        /* val responseLiveData = tvShowViewModel.getTvShows()
         responseLiveData.observe(this, Observer {
             Log.i("TAGGG",it.toString())
         })*/
        initRecyclerView()
    }

    private fun initRecyclerView(){
        tvShowBinding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvAdapter()
        tvShowBinding.tvShowRecyclerView.adapter = adapter
        displayPopularTvShows()
    }

    private fun displayPopularTvShows(){
        tvShowBinding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                tvShowBinding.tvShowProgressBar.visibility = View.GONE
            }else {
                tvShowBinding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()
            }
        })
    }

    // menu icon to display for update
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else ->
                super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows(){
        tvShowBinding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.updateTvShows()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                tvShowBinding.tvShowProgressBar.visibility = View.GONE
            }else {
                tvShowBinding.tvShowProgressBar.visibility = View.GONE
            }
        })
    }
}
