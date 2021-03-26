package com.example.themoviedbkotlin.ui.main.UI.movie

import com.example.themoviedbkotlin.ui.main.Models.MoreMovieDetails
import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails

interface MovieDetailsContract {
    interface View{
        fun showMovieDetails(movieDetails: MoviesDetails)
    }

    interface UserActionListener{
        fun loadMovieDetails(moviesDetails: MoviesDetails)
    }
}