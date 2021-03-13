package com.example.themoviedbkotlin.ui.main.API

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {

    private var BASE_URL = "https://api.themoviedb.org/3/"
    private var retrofit: Retrofit? = null

    val gson: Gson = GsonBuilder()
            .create()

    fun getClient(): Retrofit {
        if (retrofit==null){
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
        }
        return this.retrofit!!
    }
}