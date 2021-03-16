package com.example.themoviedbkotlin.ui.main.API

import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails
import com.example.themoviedbkotlin.ui.main.Models.MovieResponse

interface ServiceApi {
    interface ServiceApiCallback<T>{
        fun onLoaded(movies: List<MoviesDetails>)
    }
    fun getPopularMovies(apiKey: String?, callback: ServiceApiCallback<MovieResponse>)
    fun getTopRatedMovies(apiKey: String?, callback: ServiceApiCallback<MovieResponse>)
    fun getUpcomingMovies(apiKey: String?, callback: ServiceApiCallback<MovieResponse>)
    fun getSearchMovie(apiKey: String?, searchMovie: String?, callback: ServiceApiCallback<MovieResponse>)
    fun getMovieDetails(apiKey: String?, movieId: Int, callback: ServiceApiCallback<MovieResponse>)
}