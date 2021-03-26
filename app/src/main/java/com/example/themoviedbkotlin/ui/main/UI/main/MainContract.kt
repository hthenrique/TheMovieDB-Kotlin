package com.example.themoviedbkotlin.ui.main.UI.main

import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails

interface MainContract {
    interface View{
        fun showPopularMovies(popularMovies: List<MoviesDetails>)
        fun showTopRatedMovies(topRatedMovies: List<MoviesDetails>)
        fun showUpcomingMovies(upcomingMovies: List<MoviesDetails>)
        fun showSearchMovies(searchMovies: List<MoviesDetails>)
    }

    interface UserActionListener{
        fun loadPopularMovies()
        fun loadTopRatedMovies()
        fun loadUpcomingMovies()
        fun loadSearchMovies(searchMovie: String)
    }
}