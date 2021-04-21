package com.example.themoviedbkotlin.ui.main.UI.movie

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

        val movieId = activity?.intent!!.extras!!.getInt("movieId")

        movieDetailsListener = MovieDetailsPresenter(this)
        movieDetailsListener.loadMovieDetails(movieId)

        backgroundPoster = view.findViewById(R.id.backgroundPoster)
        moviePoster = view.findViewById(R.id.movieDetailsPoster)
        movieTitle = view.findViewById(R.id.movieDetailsTitle)
        movieDetailsRate = view.findViewById(R.id.movieDetailsRate)
        movieReleaseDate = view.findViewById(R.id.movieDetailsReleaseDate)
        movieBudget = view.findViewById(R.id.movieBudget)
        movieGenre = view.findViewById(R.id.movieGenre)
        movieOverview = view.findViewById(R.id.movieOverview)

        return view
    }

    override fun showMovieDetails(moreMovieDetails: MoreMovieDetails) {
        movieTitle.text = moreMovieDetails.title
        movieReleaseDate.text = moreMovieDetails.releaseDate
        movieOverview.text = moreMovieDetails.overview
        movieDetailsRate.rating = (moreMovieDetails.voteAverage.toFloat()) / 2

        Picasso.get()
                .load("http://image.tmdb.org/t/p/original/" + moreMovieDetails.backdrop_path)
                .fit().centerCrop()
                .into(backgroundPoster)

        Picasso.get()
                .load("http://image.tmdb.org/t/p/original/" + moreMovieDetails.posterPath)
                .fit().centerCrop()
                .into(moviePoster)
    }

}