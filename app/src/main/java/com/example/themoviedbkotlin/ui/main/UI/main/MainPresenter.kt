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

    private var popularMoviesPage: Int = 1
    private var topRatedMoviesPage: Int = 1
    private var upcomingMoviesPage: Int = 1
    private var searchMoviesPage: Int = 1

    init {
        serviceApi = RequestApi(context)
        mMoviesView = moviesView
        searchMoviesView = moviesSearch
    }

    override fun loadPopularMovies(page: Int) {
        popularMoviesPage = page
        serviceApi.getPopularMovies(apiKey, page, object : ServiceApi.ServiceApiCallback<MoviesResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView?.showPopularMovies(movies)
            }
        })
    }

    override fun loadMorePopularMovies() {
        popularMoviesPage++
        serviceApi.getPopularMovies(apiKey, popularMoviesPage, object : ServiceApi.ServiceApiCallback<MoviesResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView?.showMorePopularMovies(movies)
            }
        })
    }

    override fun loadTopRatedMovies(page: Int) {
        topRatedMoviesPage = page
        serviceApi.getTopRatedMovies(apiKey, page, object : ServiceApi.ServiceApiCallback<MoviesResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView?.showTopRatedMovies(movies)
            }
        })
    }

    override fun loadMoreTopRatedMovies() {
        topRatedMoviesPage++
        serviceApi.getTopRatedMovies(apiKey, topRatedMoviesPage, object : ServiceApi.ServiceApiCallback<MoviesResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView?.showMoreTopRatedMovies(movies)
            }
        })
    }

    override fun loadUpcomingMovies(page: Int) {
        upcomingMoviesPage = page
        serviceApi.getUpcomingMovies(apiKey, page, object : ServiceApi.ServiceApiCallback<MoviesResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView?.showUpcomingMovies(movies)
            }
        })
    }

    override fun loadMoreUpcomingMovies() {
        upcomingMoviesPage++
        serviceApi.getUpcomingMovies(apiKey, upcomingMoviesPage, object : ServiceApi.ServiceApiCallback<MoviesResponse> {
            override fun onLoaded(movies: List<MoviesDetails>) {
                mMoviesView?.showMoreUpcomingMovies(movies)
            }
        })
    }

    override fun loadSearchMovies(searchMovie: String, page: Int) {
        searchMoviesPage = page
        serviceApi.getSearchMovie(apiKey, searchMovie, page, object : ServiceApi.ServiceApiCallback<MoviesResponse>{
            override fun onLoaded(movies: List<MoviesDetails>) {
                searchMoviesView?.showSearchMovies(movies)
            }
        })
    }


}