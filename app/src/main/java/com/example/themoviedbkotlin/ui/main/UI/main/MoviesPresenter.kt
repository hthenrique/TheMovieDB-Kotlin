package com.example.themoviedbkotlin.ui.main.UI.main

import android.content.Context
import com.example.themoviedbkotlin.ui.main.API.RequestApi
import com.example.themoviedbkotlin.ui.main.API.ServiceApi
import com.example.themoviedbkotlin.ui.main.Models.MovieResponse
import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails

class MoviesPresenter(moviesView: MoviesContract.View): MoviesContract.UserActionListener {
    val serviceApi: ServiceApi
    val mMoviesView: MoviesContract.View
    var context: Context? = null
    private var apiKey: String = "38594c476985d7c2fad6093dc2ac98f7"

    override fun loadPopularMovies() {
        serviceApi.getPopularMovies(apiKey, object : ServiceApi.ServiceApiCallback<MovieResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView.showPopularMovies(movies)
            }
        })
    }

    override fun loadTopRatedMovies() {
        serviceApi.getTopRatedMovies(apiKey, object : ServiceApi.ServiceApiCallback<MovieResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView.showTopRatedMovies(movies)
            }
        })
    }

    override fun loadUpcomingMovies() {
        serviceApi.getUpcomingMovies(apiKey, object : ServiceApi.ServiceApiCallback<MovieResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView.showUpcomingMovies(movies)
            }

        })
    }

    override fun loadSearchMovies(searchMovie: String) {
        serviceApi.getSearchMovie(apiKey, searchMovie, object : ServiceApi.ServiceApiCallback<MovieResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView.showSearchMovies(movies)
            }

        })
    }

    init {
        serviceApi = RequestApi(context)
        mMoviesView = moviesView
    }
}