package com.example.kotlin.tc2007bexamandroid.framework.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//Adapt to new api
class MainViewModel: ViewModel() {
    val movieLiveData = MutableLiveData<Movie>()
    private val movieListRequirement = MovieListRequirement()

    fun getMovieList(){
        viewModelScope.launch(Dispatchers.IO) {
            val result: Movie? = movieListRequirement()
            Log.d("Salida", result?.total_results.toString())
            CoroutineScope(Dispatchers.Main).launch {
                movieLiveData.postValue(result!!)
            }
        }
    }
}