package com.example.themoviedbkotlin.ui.main.UI.Listeners

import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails

interface MovieListener {
    fun onMovieItemClicked(movieDetails: MoviesDetails)
}