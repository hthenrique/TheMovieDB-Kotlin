package com.example.themoviedbkotlin.ui.main.API

import com.example.themoviedbkotlin.ui.main.Models.MovieDetails
import com.example.themoviedbkotlin.ui.main.Models.MovieResponse

interface ServiceApi {
    interface ServiceApiCallback<T>{
        fun onLoaded(movies: List<MovieDetails>)
    }
    fun getMovies(apiKey: String?, callback: ServiceApiCallback<MovieResponse>)
    fun getMoviesTopRated(apiKey: String?, callback: ServiceApiCallback<MovieResponse>)
    fun getSearch(apiKey: String?, query: String?, callback: ServiceApiCallback<MovieResponse>)
}