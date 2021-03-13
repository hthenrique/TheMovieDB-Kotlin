package com.example.themoviedbkotlin.ui.main.Models

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class MovieResponse {

    @SerializedName("page")
    var page: Int = 0

    @SerializedName("total_results")
    var totalResults: Int = 0

    @SerializedName("total_pages")
    var totalPages: Int = 0

    @field:SerializedName("results")
    lateinit var results: ArrayList<MovieDetails>
}