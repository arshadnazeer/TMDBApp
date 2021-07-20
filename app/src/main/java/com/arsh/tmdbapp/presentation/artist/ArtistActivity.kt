package com.arsh.tmdbapp.presentation.artist

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
import com.arsh.tmdbapp.databinding.ActivityArtistBinding
import com.arsh.tmdbapp.databinding.ActivityMovieBinding
import com.arsh.tmdbapp.presentation.di.Injector
import com.arsh.tmdbapp.presentation.movie.MovieAdapter
import com.arsh.tmdbapp.presentation.movie.MovieViewModel
import com.arsh.tmdbapp.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var artistViewModelFactory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter
    private lateinit var artistBinding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        artistBinding = DataBindingUtil.setContentView(this,R.layout.activity_artist)
        (application as Injector).createArtistSubcomponent()
            .inject(this)

        artistViewModel= ViewModelProvider(this,artistViewModelFactory).get(ArtistViewModel::class.java)
        /* val responseLiveData = movieViewModel.getMovies()
         responseLiveData.observe(this, Observer {
             Log.i("TAGGG",it.toString())
         })*/
        initRecyclerView()
    }

    private fun initRecyclerView(){
        artistBinding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        artistBinding.artistRecyclerView.adapter = adapter
        displayPopularArtists()
    }

    private fun displayPopularArtists(){
        artistBinding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtist()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                artistBinding.artistProgressBar.visibility = View.GONE
            }else {
                artistBinding.artistProgressBar.visibility = View.GONE
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
                updateArtists()
                true
            }
            else ->
                super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtists(){
        artistBinding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.updateArtist()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                artistBinding.artistProgressBar.visibility = View.GONE
            }else {
                artistBinding.artistProgressBar.visibility = View.GONE
            }
        })
    }
}