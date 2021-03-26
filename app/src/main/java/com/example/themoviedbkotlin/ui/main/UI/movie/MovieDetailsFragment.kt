package com.example.themoviedbkotlin.ui.main.UI.movie

import android.graphics.Movie
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.themoviedbkotlin.R
import com.example.themoviedbkotlin.ui.main.Models.MoreMovieDetails
import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails
import com.squareup.picasso.Picasso

class MovieDetailsFragment : Fragment(), MovieDetailsContract.View {

    lateinit var backgroundPoster: ImageView
    lateinit var moviePoster: ImageView
    lateinit var movieTitle: TextView
    lateinit var movieDetailsRate: RatingBar
    lateinit var movieReleaseDate: TextView
    lateinit var movieBudget: TextView
    lateinit var movieGenre: TextView
    lateinit var movieOverview: TextView

    lateinit var movieDetailsListener: MovieDetailsContract.UserActionListener

    companion object{
        fun newInstance() = MovieDetailsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.movie_details_fragment, container, false)
        val moviesDetails = MoviesDetails()

        val movieId = activity?.intent!!.extras!!.getInt("movieId")
        val title = activity?.intent!!.extras!!.getString("title")
        val posterPath = activity?.intent!!.extras!!.getString("posterPath")
        val backdrop_path = activity?.intent!!.extras!!.getString("backdrop_path")
        val voteAverage = activity?.intent!!.extras!!.getDouble("voteAverage")
        val releaseDate = activity?.intent!!.extras!!.getString("releaseDate")
        val overview = activity?.intent!!.extras!!.getString("overview")

        moviesDetails.id = movieId
        movieDetailsListener = MovieDetailsPresenter(this)
        movieDetailsListener.loadMovieDetails(moviesDetails)
        onResume(moviesDetails)

        backgroundPoster = view.findViewById(R.id.backgroundPoster)
        moviePoster = view.findViewById(R.id.movieDetailsPoster)
        movieTitle = view.findViewById(R.id.movieDetailsTitle)
        movieDetailsRate = view.findViewById(R.id.movieDetailsRate)
        movieReleaseDate = view.findViewById(R.id.movieDetailsReleaseDate)
        movieBudget = view.findViewById(R.id.movieBudget)
        movieGenre = view.findViewById(R.id.movieGenre)
        movieOverview = view.findViewById(R.id.movieOverview)

        movieTitle.text = title
        movieReleaseDate.text = releaseDate
        movieOverview.text = overview
        movieDetailsRate.rating = (voteAverage.toFloat()) / 2

        Picasso.get()
            .load("http://image.tmdb.org/t/p/original/" + backdrop_path)
            .fit().centerCrop()
            .into(backgroundPoster)

        Picasso.get()
            .load("http://image.tmdb.org/t/p/original/" + posterPath)
            .fit().centerCrop()
            .into(moviePoster)

        return view
    }

    private fun onResume(moviesDetails: MoviesDetails) {
        movieDetailsListener.loadMovieDetails(moviesDetails)
    }

    override fun showMovieDetails(moviesDetails: MoviesDetails) {
        movieTitle.text = moviesDetails.title
    }

}