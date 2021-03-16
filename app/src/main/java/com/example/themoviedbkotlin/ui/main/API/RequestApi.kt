package com.example.themoviedbkotlin.ui.main.API

import android.content.Context
import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails
import com.example.themoviedbkotlin.ui.main.Models.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestApi(private val context: Context?) : ServiceApi{
    
    val retrofitClient: RetrofitClient = RetrofitClient()
    val retrofitEndPoint = retrofitClient.getClient().create(RetrofitEndPoint::class.java)

    override fun getPopularMovies(apiKey: String?, callback: ServiceApi.ServiceApiCallback<MovieResponse>) {
        val callMovies = retrofitEndPoint.getPopularMovies(apiKey, 1)
        callMovies.enqueue(object: Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.code() == 200){
                    val moviesDetails: List<MoviesDetails> = response.body()!!.results
                    callback.onLoaded(moviesDetails)
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun getTopRatedMovies(apiKey: String?, callback: ServiceApi.ServiceApiCallback<MovieResponse>) {
        val callTopRated = retrofitEndPoint.getTopRatedMovies(apiKey)
        callTopRated.enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.code() == 200){
                    val moviesDetails: List<MoviesDetails> = response.body()!!.results
                    callback.onLoaded(moviesDetails)
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun getUpcomingMovies(apiKey: String?, callback: ServiceApi.ServiceApiCallback<MovieResponse>) {
        val callUpcoming = retrofitEndPoint.getUpcomingMovies(apiKey)
        callUpcoming.enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.code() == 200){
                    val moviesDetails: List<MoviesDetails> = response.body()!!.results
                    callback.onLoaded(moviesDetails)
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun getSearchMovie(apiKey: String?, searchMovie: String?, callback: ServiceApi.ServiceApiCallback<MovieResponse>) {
        val callSearch = retrofitEndPoint.getSearchMovie(apiKey, searchMovie)
        callSearch.enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.code() == 200){
                    val moviesDetails: List<MoviesDetails> = response.body()!!.results
                    callback.onLoaded(moviesDetails)
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun getMovieDetails(apiKey: String?, movieId: Int, callback: ServiceApi.ServiceApiCallback<MovieResponse>) {
        val callDetails = retrofitEndPoint.getMovieDetails(apiKey, movieId)
        callDetails.enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.code() == 200){
                    val moviesDetails: List<MoviesDetails> = response.body()!!.results
                    callback.onLoaded(moviesDetails)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}



