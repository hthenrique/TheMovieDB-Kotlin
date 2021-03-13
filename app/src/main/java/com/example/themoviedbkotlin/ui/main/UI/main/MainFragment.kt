package com.example.themoviedbkotlin.ui.main.UI.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.themoviedbkotlin.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() =
            MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

}