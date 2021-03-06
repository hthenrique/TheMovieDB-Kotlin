package com.example.themoviedbkotlin.ui.main.API

import android.content.Context
import android.util.Log
import com.example.themoviedbkotlin.ui.main.Models.MoreMovieDetails
import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails
import com.example.themoviedbkotlin.ui.main.Models.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestApi(private val context: Context?) : ServiceApi{
    
    val retrofitClient: RetrofitClient = RetrofitClient()
    val retrofitEndPoint = retrofitClient.getClient().create(RetrofitEndPoint::class.java)

    override fun getPopularMovies(apiKey: String?, page: Int?, callback: ServiceApi.ServiceApiCallback<MoviesResponse>) {
        val callMovies = retrofitEndPoint.getPopularMovies(apiKey, page)
        callMovies.enqueue(object: Callback<MoviesResponse>{
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                System.out.println("Response " + response.code())
                if (response.code() == 200){
                    val moviesDetails: List<MoviesDetails> = response.body()!!.results
                    callback.onLoaded(moviesDetails)
                }
            }
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                System.out.println("Failure " + t.toString())
            }
        })
    }

    override fun getTopRatedMovies(apiKey: String?, page: Int?, callback: ServiceApi.ServiceApiCallback<MoviesResponse>) {
        val callTopRated = retrofitEndPoint.getTopRatedMovies(apiKey, page)
        callTopRated.enqueue(object : Callback<MoviesResponse>{
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                if (response.code() == 200){
                    val moviesDetails: List<MoviesDetails> = response.body()!!.results
                    callback.onLoaded(moviesDetails)
                }
            }
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                System.out.println("Failure " + t.toString())
            }

        })
    }

    override fun getUpcomingMovies(apiKey: String?, page: Int?, callback: ServiceApi.ServiceApiCallback<MoviesResponse>) {
        val callUpcoming = retrofitEndPoint.getUpcomingMovies(apiKey, page)
        callUpcoming.enqueue(object : Callback<MoviesResponse>{
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                if (response.code() == 200){
                    val moviesDetails: List<MoviesDetails> = response.body()!!.results
                    callback.onLoaded(moviesDetails)
                }
            }
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                System.out.println("Failure " + t.toString())
            }

        })
    }

    override fun getSearchMovie(apiKey: String?, searchMovie: String?, page: Int?, callback: ServiceApi.ServiceApiCallback<MoviesResponse>) {
        val callSearch = retrofitEndPoint.getSearchMovie(apiKey, searchMovie, page)
        callSearch.enqueue(object : Callback<MoviesResponse>{
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                if (response.code() == 200){
                    val moviesDetails: List<MoviesDetails> = response.body()!!.results
                    callback.onLoaded(moviesDetails)
                    System.out.println("Search " + moviesDetails)
                }
            }
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                System.out.println("Failure " + t.toString())
            }
        })
    }

    override fun getMovieDetails(apiKey: String?, movieId: Int, callback: ServiceApi.ServiceApiCallback2<MoreMovieDetails>) {
        val callDetails = retrofitEndPoint.getMovieDetails(movieId, apiKey)
        callDetails.enqueue(object : Callback<MoreMovieDetails>{
            override fun onResponse(call: Call<MoreMovieDetails>, response: Response<MoreMovieDetails>) {
                if (response.code() == 200){
                    val moreMovieDetails: MoreMovieDetails = response.body()!!
                    callback.onLoaded(moreMovieDetails)
                }else{
                    System.out.println("More Details Response Error:  " + response.code().toString())
                }
            }
            override fun onFailure(call: Call<MoreMovieDetails>, t: Throwable) {
                System.out.println("Failure " + t.toString())
            }
        })
    }
}



