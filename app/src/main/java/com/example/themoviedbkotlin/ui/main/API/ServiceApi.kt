package com.example.themoviedbkotlin.ui.main.API

import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails
import com.example.themoviedbkotlin.ui.main.Models.MoviesResponse

interface ServiceApi {
    interface ServiceApiCallback<T>{
        fun onLoaded(movies: List<MoviesDetails>)
    }
    interface ServiceApiCallback2<T>{
        fun onLoaded(moreMovieDetails: MoviesDetails)
    }
    fun getPopularMovies(apiKey: String?, page: Int?, callback: ServiceApiCallback<MoviesResponse>)
    fun getTopRatedMovies(apiKey: String?, page: Int?, callback: ServiceApiCallback<MoviesResponse>)
    fun getUpcomingMovies(apiKey: String?, page: Int?, callback: ServiceApiCallback<MoviesResponse>)
    fun getSearchMovie(apiKey: String?, searchMovie: String?, page: Int?, callback: ServiceApiCallback<MoviesResponse>)
    fun getMovieDetails(apiKey: String?, movieId: Int, callback: ServiceApiCallback2<MoviesDetails>)

}