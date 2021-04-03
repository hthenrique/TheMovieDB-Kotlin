package com.example.themoviedbkotlin.ui.main.UI.main

import android.content.Context
import com.example.themoviedbkotlin.ui.main.API.RequestApi
import com.example.themoviedbkotlin.ui.main.API.ServiceApi
import com.example.themoviedbkotlin.ui.main.Models.MoviesResponse
import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails

class MainPresenter(moviesView: MainContract.View?, moviesSearch: MainContract.Search?): MainContract.UserActionListener {
    val serviceApi: ServiceApi
    val mMoviesView: MainContract.View?
    val searchMoviesView: MainContract.Search?
    var context: Context? = null
    private var apiKey: String = "38594c476985d7c2fad6093dc2ac98f7"

    init {
        serviceApi = RequestApi(context)
        mMoviesView = moviesView
        searchMoviesView = moviesSearch
    }

    override fun loadPopularMovies() {
        serviceApi.getPopularMovies(apiKey, object : ServiceApi.ServiceApiCallback<MoviesResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView?.showPopularMovies(movies)
            }
        })
    }

    override fun loadTopRatedMovies() {
        serviceApi.getTopRatedMovies(apiKey, object : ServiceApi.ServiceApiCallback<MoviesResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView?.showTopRatedMovies(movies)
            }
        })
    }

    override fun loadUpcomingMovies() {
        serviceApi.getUpcomingMovies(apiKey, object : ServiceApi.ServiceApiCallback<MoviesResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView?.showUpcomingMovies(movies)
            }
        })
    }

    override fun loadSearchMovies(searchMovie: String) {
        serviceApi.getSearchMovie(apiKey, searchMovie, object : ServiceApi.ServiceApiCallback<MoviesResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                searchMoviesView?.showSearchMovies(movies)
            }
        })
    }
}