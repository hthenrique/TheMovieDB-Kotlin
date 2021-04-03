package com.example.themoviedbkotlin.ui.main.UI.main

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.solver.state.State
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedbkotlin.R
import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails
import com.example.themoviedbkotlin.ui.main.UI.Adapters.SearchMoviesAdapter
import com.example.themoviedbkotlin.ui.main.UI.Listeners.MovieListener
import com.example.themoviedbkotlin.ui.main.UI.movie.MovieDetailsActivity

class SearchFragment(val query: String) : Fragment(), MainContract.Search, MovieListener {

    lateinit var movieListener: MainContract.UserActionListener
    lateinit var searchMoviesList: RecyclerView
    lateinit var searchMoviesAdapter: SearchMoviesAdapter
    lateinit var noResultsLayout: ConstraintLayout
    lateinit var resultsLayout: LinearLayout

    companion object {
        fun newInstance(query: String) = SearchFragment(query)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_search, container, false)

        movieListener = MainPresenter(null, this)

        searchMoviesList = view.findViewById(R.id.searchMoviesList)
        //noResultsLayout = view.findViewById(R.id.noResultsLayout)
        resultsLayout = view.findViewById(R.id.resultsLayout)

        searchMoviesAdapter = SearchMoviesAdapter(ArrayList(0), this, context)
        searchMoviesList.layoutManager = GridLayoutManager(context, 2)
        searchMoviesList.adapter = searchMoviesAdapter

        return view
    }

    override fun onResume() {
        super.onResume()
        movieListener.loadSearchMovies(query)

    }

    override fun showSearchMovies(searchMovies: List<MoviesDetails>) {
        searchMoviesAdapter.replaceData(searchMovies)
        //noResultsLayout.visibility = View.GONE
        //resultsLayout.visibility = View.VISIBLE
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