package com.example.themoviedbkotlin.ui.main.UI.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedbkotlin.R
import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails
import com.squareup.picasso.Picasso
import java.util.*

class TopRatedMoviesAdapter(var movies: List<MoviesDetails>, val context: Context?): RecyclerView.Adapter<TopRatedMoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_movie_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val moviesDetails: MoviesDetails = movies.get(position)
        val posterLink: String = "http://image.tmdb.org/t/p/original/" + moviesDetails.posterPath
        val movieId: Int = moviesDetails.id
        val title: String = moviesDetails.title
        val releaseDate: String = moviesDetails.releaseDate
        val voteAverage: Double = moviesDetails.voteAverage

        Picasso.get()
                .load(posterLink)
                .fit().centerCrop()
                .into(holder.moviePoster)
        holder.movieRate.rating = (voteAverage.toFloat()) / 2
        holder.movieTitle.text = title
        holder.movieReleaseDate.text = releaseDate
        holder.itemView.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun replaceData(listMovies: List<MoviesDetails>){
        setList(listMovies)
        notifyDataSetChanged()
    }

    fun setList(listMovies: List<MoviesDetails>) {
        movies = listMovies
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val moviePoster: ImageView = itemView.findViewById(R.id.moviePoster)
        val movieRate: RatingBar = itemView.findViewById(R.id.movieRate)
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val movieReleaseDate: TextView = itemView.findViewById(R.id.movieReleaseDate)
    }
}