package com.example.themoviedbkotlin.ui.main.API

import com.example.themoviedbkotlin.ui.main.Models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitEndPoint {

    @GET("movie/popular/")
    fun getPopularMovies(@Query("api_key") apiKey: String?, @Query("page") page: Int): Call<MovieResponse>

    @GET("movie/top_rated/")
    fun getTopRatedMovies(@Query("api_key") apiKey: String?): Call<MovieResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovies(@Query("api_key") apiKey: String?): Call<MovieResponse>

    @GET("serach/multi")
    fun getSearchMovie(@Query("api_key") apiKey: String?, @Query("query") searchMovie: String?): Call<MovieResponse>

    @GET("movie/")
    fun getMovieDetails(@Query("api_key") apiKey: String?, @Query("movie_id") page: Int): Call<MovieResponse>
}