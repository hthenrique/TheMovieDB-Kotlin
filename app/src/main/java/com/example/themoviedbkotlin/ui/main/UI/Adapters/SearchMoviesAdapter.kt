package com.example.themoviedbkotlin.ui.main.UI.Adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedbkotlin.ui.main.Models.MoviesDetails
import java.util.ArrayList

class SearchMoviesAdapter(var movies: ArrayList<MoviesDetails>, val context: Context?): RecyclerView.Adapter<SearchMoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}