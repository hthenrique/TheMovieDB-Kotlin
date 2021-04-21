package com.example.themoviedbkotlin.ui.main.API

import com.example.themoviedbkotlin.ui.main.Models.MoreMovieDetails
import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails
import com.example.themoviedbkotlin.ui.main.Models.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitEndPoint {

    @GET("movie/popular/")
    fun getPopularMovies(@Query("api_key") apiKey: String?, @Query("page") page: Int?): Call<MoviesResponse>

    @GET("movie/top_rated/")
    fun getTopRatedMovies(@Query("api_key") apiKey: String?, @Query("page") page: Int?): Call<MoviesResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovies(@Query("api_key") apiKey: String?, @Query("page") page: Int?): Call<MoviesResponse>

    @GET("search/multi")
    fun getSearchMovie(@Query("api_key") apiKey: String?, @Query("query") searchMovie: String?, @Query("page") page: Int?): Call<MoviesResponse>

    @GET("movie/{movie_id}?")
    fun getMovieDetails(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String?): Call<MoreMovieDetails>
}