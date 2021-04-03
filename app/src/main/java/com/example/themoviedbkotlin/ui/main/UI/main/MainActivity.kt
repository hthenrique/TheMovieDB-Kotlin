package com.example.themoviedbkotlin.ui.main.UI.main

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat
import com.example.themoviedbkotlin.R

class MainActivity : AppCompatActivity() {

    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment.newInstance()).commitNow()
        }
        val mainToolbar: Toolbar = findViewById(R.id.mainToolbar)
        setSupportActionBar(mainToolbar)
        mainToolbar.title = getString(R.string.app_name)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)

        ///*
        //val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu.findItem(R.id.app_bar_search)
        searchView = MenuItemCompat.getActionView(searchItem) as SearchView
        searchView.queryHint = resources.getString(R.string.search_hint)

        if (searchItem != null){
            searchView.setOnQueryTextListener(object : OnQueryTextListener{
                override fun onQueryTextSubmit(query: String): Boolean {
                    if (query.trim().isNotEmpty()){
                        supportFragmentManager.beginTransaction().replace(R.id.container, SearchFragment.newInstance(query)).commitNow()
                    }else{
                        supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment.newInstance()).commitNow()
                    }
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    if (newText.trim().isNotEmpty()){
                        supportFragmentManager.beginTransaction().replace(R.id.container, SearchFragment.newInstance(newText)).commitNow()
                    }else{
                        supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment.newInstance()).commitNow()
                    }
                    return true
                }

            })
        }
        //*/


        return super.onCreateOptionsMenu(menu)
    }
}