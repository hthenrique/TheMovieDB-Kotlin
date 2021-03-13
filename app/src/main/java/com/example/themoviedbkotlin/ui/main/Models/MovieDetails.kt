package com.example.themoviedbkotlin.ui.main.Models

import android.icu.text.CaseMap
import com.google.gson.annotations.SerializedName
import org.intellij.lang.annotations.Language

class MovieDetails {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("original_title")
    var originalTitle: String = ""

    @SerializedName("original_language")
    var originalLanguage: String = ""

    @SerializedName("title")
    var title: String = ""

    @SerializedName("poster_path")
    var posterPath: String = ""

    @SerializedName("popularity")
    var popularity: String = ""

    @SerializedName("vote_count")
    var voteCount: Int = 0

    @SerializedName("vote_average")
    var voteAverage: Double = 0.0

    @SerializedName("overview")
    var overview: String = ""

    @SerializedName("release_date")
    var releaseDate: String = ""

    @SerializedName("genre_ids")
    var genreIds: List<Integer> = ArrayList()
}