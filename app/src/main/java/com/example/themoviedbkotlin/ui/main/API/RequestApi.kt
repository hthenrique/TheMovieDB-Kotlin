package com.example.themoviedbkotlin.ui.main.API

import android.content.Context
import com.example.themoviedbkotlin.ui.main.Models.MovieDetails
import com.example.themoviedbkotlin.ui.main.Models.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class RequestApi(private val context: Context) : ServiceApi{
    
    val retrofitClient: RetrofitClient = RetrofitClient()
    val retrofitEndPoint = retrofitClient.getClient().create(RetrofitEndPoint::class.java)

    override fun getMovies(apiKey: String?, callback: ServiceApi.ServiceApiCallback<MovieResponse>) {
        val callMovies = retrofitEndPoint.getMovies(apiKey, 1)
        callMovies?.enqueue(object: Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.code() == 200){
                    val movieDetails: List<MovieDetails> = response.body()!!.results
                    callback.onLoaded(movieDetails)
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun getMoviesTopRated(apiKey: String?, callback: ServiceApi.ServiceApiCallback<MovieResponse>) {

    }

    override fun getSearch(apiKey: String?, query: String?, callback: ServiceApi.ServiceApiCallback<MovieResponse>) {
        TODO("Not yet implemented")
    }


}



