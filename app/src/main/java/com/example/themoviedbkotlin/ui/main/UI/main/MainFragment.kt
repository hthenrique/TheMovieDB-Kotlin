package com.example.themoviedbkotlin.ui.main.UI.main

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedbkotlin.R
import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails
import com.example.themoviedbkotlin.ui.main.UI.Adapters.MoviesPopularAdapter
import com.example.themoviedbkotlin.ui.main.UI.Adapters.TopRatedMoviesAdapter
import com.example.themoviedbkotlin.ui.main.UI.Adapters.UpcomingMoviesAdapter
import java.util.ArrayList

class MainFragment : Fragment(), MoviesContract.View {

    lateinit var popularMoviesList: RecyclerView
    lateinit var topRatedMoviesList: RecyclerView
    lateinit var upcomingMoviesList: RecyclerView
    lateinit var moviesPopularAdapter: MoviesPopularAdapter
    lateinit var topRatedMoviesAdapter: TopRatedMoviesAdapter
    lateinit var upcomingMoviesAdapter: UpcomingMoviesAdapter
    lateinit var movieListener: MoviesContract.UserActionListener

    var apiKey: String = "38594c476985d7c2fad6093dc2ac98f7"

    companion object {
        fun newInstance() = MainFragment()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.main_fragment, container, false)

        movieListener = MoviesPresenter(this)

        popularMoviesList = view.findViewById(R.id.popularMoviesList)
        topRatedMoviesList = view.findViewById(R.id.topRatedMoviesList)
        upcomingMoviesList = view.findViewById(R.id.upcomingMoviesList)

        moviesPopularAdapter = MoviesPopularAdapter(ArrayList(0), context)
        topRatedMoviesAdapter = TopRatedMoviesAdapter(ArrayList(0), context)
        upcomingMoviesAdapter = UpcomingMoviesAdapter(ArrayList(0), context)

        popularMoviesList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        topRatedMoviesList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        upcomingMoviesList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        popularMoviesList.adapter = moviesPopularAdapter
        topRatedMoviesList.adapter = topRatedMoviesAdapter
        upcomingMoviesList.adapter = upcomingMoviesAdapter
        return view
    }

    override fun onResume() {
        super.onResume()
        movieListener.loadPopularMovies()
        movieListener.loadTopRatedMovies()
        movieListener.loadUpcomingMovies()
    }

    override fun showPopularMovies(popularMovies: List<MoviesDetails>) {
        moviesPopularAdapter.replaceData(popularMovies)
    }

    override fun showTopRatedMovies(topRatedMovies: List<MoviesDetails>) {
        topRatedMoviesAdapter.replaceData(topRatedMovies)
    }

    override fun showUpcomingMovies(upcomingMovies: List<MoviesDetails>) {
        upcomingMoviesAdapter.replaceData(upcomingMovies)
    }

    override fun showSearchMovies(searchMovies: List<MoviesDetails>) {
        TODO("Not yet implemented")
    }

}