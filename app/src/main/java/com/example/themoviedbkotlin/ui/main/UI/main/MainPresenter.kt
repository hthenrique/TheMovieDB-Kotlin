package com.example.themoviedbkotlin.ui.main.UI.main

import android.content.Context
import android.os.Build
import com.example.themoviedbkotlin.BuildConfig
import com.example.themoviedbkotlin.ui.main.API.RequestApi
import com.example.themoviedbkotlin.ui.main.API.ServiceApi
import com.example.themoviedbkotlin.ui.main.Models.MoviesResponse
import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails

class MainPresenter(moviesView: MainContract.View?, moviesSearch: MainContract.Search?): MainContract.UserActionListener {
    val serviceApi: ServiceApi
    val mMoviesView: MainContract.View?
    val searchMoviesView: MainContract.Search?
    var context: Context? = null
    private var apiKey: String = BuildConfig.TMDB_API_KEY

    init {
        serviceApi = RequestApi(context)
        mMoviesView = moviesView
        searchMoviesView = moviesSearch
    }

    override fun loadPopularMovies(page: Int) {
        serviceApi.getPopularMovies(apiKey, page, object : ServiceApi.ServiceApiCallback<MoviesResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView?.showPopularMovies(movies)
            }
        })
    }

    override fun loadTopRatedMovies(page: Int) {
        serviceApi.getTopRatedMovies(apiKey, page, object : ServiceApi.ServiceApiCallback<MoviesResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView?.showTopRatedMovies(movies)
            }
        })
    }

    override fun loadUpcomingMovies(page: Int) {
        serviceApi.getUpcomingMovies(apiKey, page, object : ServiceApi.ServiceApiCallback<MoviesResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView?.showUpcomingMovies(movies)
            }
        })
    }

    override fun loadSearchMovies(searchMovie: String, page: Int) {
        serviceApi.getSearchMovie(apiKey, searchMovie, page, object : ServiceApi.ServiceApiCallback<MoviesResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                searchMoviesView?.showSearchMovies(movies)
            }
        })
    }
}