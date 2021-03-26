package com.example.themoviedbkotlin.ui.main.UI.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.themoviedbkotlin.R
import com.example.themoviedbkotlin.ui.main.UI.main.MainFragment
import com.example.themoviedbkotlin.ui.main.UI.main.MainFragment.Companion.newInstance
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MovieDetailsActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var backButton: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.detailsContainer, MovieDetailsFragment.newInstance()).commitNow()
        }
        backButton = findViewById(R.id.backbutton)
        backButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.backbutton -> onBackPressed()
        }
    }
}