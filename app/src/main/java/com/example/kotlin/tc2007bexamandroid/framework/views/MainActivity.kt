package com.example.kotlin.tc2007bexamandroid.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager

class MainActivity {
    class MainActivity: AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding
        private val adapter : MovieAdapter = MovieAdapter() //Change
        private lateinit var data:ArrayList<Movie>
        private val viewModel: MainViewModel by viewModels()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            initializeBinding()
            initializeObservers()
            viewModel.getMovieList()
        }

        private fun initializeBinding() {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
        }

        private fun setUpRecyclerView(dataForList: List<Result>) {
            binding.RVMovie.setHasFixedSize(true)

            val gridLayoutManager = GridLayoutManager(this, 2)
            binding.RVMovie.layoutManager = gridLayoutManager

            adapter.MovieAdapter(dataForList, this)
            binding.RVMovie.adapter = adapter
        }

        private fun initializeObservers(){
            viewModel.movieLiveData.observe(this){ movie ->
                setUpRecyclerView(movie.results)
            }
        }
    }

}