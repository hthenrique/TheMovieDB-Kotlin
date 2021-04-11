package com.example.themoviedbkotlin.ui.main.UI.main

import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails

interface MainContract {
    interface View{
        fun showPopularMovies(popularMovies: List<MoviesDetails>)
        fun showTopRatedMovies(topRatedMovies: List<MoviesDetails>)
        fun showUpcomingMovies(upcomingMovies: List<MoviesDetails>)
    }
    interface Search{
        fun showSearchMovies(searchMovies: List<MoviesDetails>)
    }
    interface UserActionListener{
        fun loadPopularMovies(page: Int)
        fun loadTopRatedMovies(page: Int)
        fun loadUpcomingMovies(page: Int)
        fun loadSearchMovies(searchMovie: String, page: Int)
    }
}