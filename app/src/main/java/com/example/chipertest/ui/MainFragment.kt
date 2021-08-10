package com.example.chipertest.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chipertest.R
import com.example.chipertest.adapters.BestMoviesAdapter
import com.example.chipertest.viewmodel.MainViewModel
import com.example.chipertest.models.ListMovies.Result

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
        var listofMovies = ArrayList<Result>()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerViewMovie: RecyclerView
    private lateinit var moviesAdapter: BestMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewMovie = view.findViewById(R.id.list_movies)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getMovies().observe(viewLifecycleOwner
        ) {
            Log.d("GET IN", it.toString())
            listofMovies.addAll(it.results)
            moviesAdapter = BestMoviesAdapter(listofMovies, context)
            recyclerViewMovie.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = moviesAdapter
            }
        }
    }

}