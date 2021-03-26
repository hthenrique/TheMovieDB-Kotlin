package com.example.themoviedbkotlin.ui.main.UI.movie

import android.content.Context
import com.example.themoviedbkotlin.ui.main.API.RequestApi
import com.example.themoviedbkotlin.ui.main.API.ServiceApi
import com.example.themoviedbkotlin.ui.main.Models.MoreMovieDetails
import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails

class MovieDetailsPresenter(movieDetailsView: MovieDetailsContract.View): MovieDetailsContract.UserActionListener {
    val serviceApi: ServiceApi
    val detailsView: MovieDetailsContract.View
    var context: Context? = null
    private var apiKey: String = "38594c476985d7c2fad6093dc2ac98f7"

    init {
        serviceApi = RequestApi(context)
        detailsView = movieDetailsView
    }

    override fun loadMovieDetails(moviesDetails: MoviesDetails) {
        val movieId = moviesDetails.id
        serviceApi.getMovieDetails(apiKey, movieId, object : ServiceApi.ServiceApiCallback2<MoviesDetails>{
            override fun onLoaded(movieDetails: MoviesDetails) {
                detailsView.showMovieDetails(moviesDetails)
            }
        })
    }


}