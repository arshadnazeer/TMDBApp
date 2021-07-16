package com.arsh.tmdbapp.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.arsh.tmdbapp.R
import com.arsh.tmdbapp.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {
    private lateinit var tvShowBinding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvShowBinding = DataBindingUtil.setContentView(this,R.layout.activity_tv_show)
    }
}
