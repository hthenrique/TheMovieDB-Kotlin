package com.example.themoviedbkotlin.ui.main.UI.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedbkotlin.R
import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails
import com.example.themoviedbkotlin.ui.main.UI.Adapters.MoviesPopularAdapter
import com.example.themoviedbkotlin.ui.main.UI.Adapters.TopRatedMoviesAdapter
import com.example.themoviedbkotlin.ui.main.UI.Adapters.UpcomingMoviesAdapter
import com.example.themoviedbkotlin.ui.main.UI.Listeners.MovieListener
import com.example.themoviedbkotlin.ui.main.UI.movie.MovieDetailsActivity
import java.util.ArrayList

class MainFragment : Fragment(), MainContract.View, MovieListener {

    lateinit var popularMoviesList: RecyclerView
    lateinit var topRatedMoviesList: RecyclerView
    lateinit var upcomingMoviesList: RecyclerView
    lateinit var moviesPopularAdapter: MoviesPopularAdapter
    lateinit var topRatedMoviesAdapter: TopRatedMoviesAdapter
    lateinit var upcomingMoviesAdapter: UpcomingMoviesAdapter
    lateinit var movieListener: MainContract.UserActionListener
    var popularMoviesPage: Int = 1
    var topRatedMoviesPage: Int = 1
    var upcomingMoviesPage: Int = 1

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.main_fragment, container, false)

        movieListener = MainPresenter(this, null)

        popularMoviesList = view.findViewById(R.id.popularMoviesList)
        topRatedMoviesList = view.findViewById(R.id.topRatedMoviesList)
        upcomingMoviesList = view.findViewById(R.id.upcomingMoviesList)

        moviesPopularAdapter = MoviesPopularAdapter(ArrayList(0), this, context)
        topRatedMoviesAdapter = TopRatedMoviesAdapter(ArrayList(0), this, context)
        upcomingMoviesAdapter = UpcomingMoviesAdapter(ArrayList(0), this, context)

        popularMoviesList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        topRatedMoviesList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        upcomingMoviesList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        popularMoviesList.adapter = moviesPopularAdapter
        topRatedMoviesList.adapter = topRatedMoviesAdapter
        upcomingMoviesList.adapter = upcomingMoviesAdapter

        initScrollListener()
        return view
    }

    private fun initScrollListener() {
        popularMoviesList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollHorizontally(1) && dx > 0) {
                    movieListener.loadMorePopularMovies()
                }
            }
        })

        topRatedMoviesList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollHorizontally(1) && dx > 0) {
                    movieListener.loadMoreTopRatedMovies()
                }
            }
        })

        upcomingMoviesList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollHorizontally(1) && dx > 0) {
                    movieListener.loadMoreUpcomingMovies()
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        movieListener.loadPopularMovies(1)
        movieListener.loadTopRatedMovies(1)
        movieListener.loadUpcomingMovies(1)
    }

    override fun showPopularMovies(popularMovies: List<MoviesDetails>) {
        moviesPopularAdapter.replaceData(popularMovies)
    }

    override fun showMorePopularMovies(popularMovies: List<MoviesDetails>) {
        moviesPopularAdapter.addMovies(popularMovies)
    }

    override fun showTopRatedMovies(topRatedMovies: List<MoviesDetails>) {
        topRatedMoviesAdapter.replaceData(topRatedMovies)
    }

    override fun showMoreTopRatedMovies(topRatedMovies: List<MoviesDetails>) {
        topRatedMoviesAdapter.addMovies(topRatedMovies)
    }

    override fun showUpcomingMovies(upcomingMovies: List<MoviesDetails>) {
        upcomingMoviesAdapter.replaceData(upcomingMovies)
    }

    override fun showMoreUpcomingMovies(upcomingMovies: List<MoviesDetails>) {
        upcomingMoviesAdapter.addMovies(upcomingMovies)
    }

    override fun onMovieItemClicked(movieDetails: MoviesDetails) {
        val moreMovieDetails = Intent(activity, MovieDetailsActivity::class.java)
        moreMovieDetails.putExtra("movieId", movieDetails.id)
        moreMovieDetails.putExtra("backdrop_path", movieDetails.backdrop_path)
        moreMovieDetails.putExtra("title", movieDetails.title)
        moreMovieDetails.putExtra("posterPath", movieDetails.posterPath)
        moreMovieDetails.putExtra("voteAverage", movieDetails.voteAverage)
        moreMovieDetails.putExtra("releaseDate", movieDetails.releaseDate)
        moreMovieDetails.putExtra("overview", movieDetails.overview)
        context?.startActivity(moreMovieDetails)
    }

}