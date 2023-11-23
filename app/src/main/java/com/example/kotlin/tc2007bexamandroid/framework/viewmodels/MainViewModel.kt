package com.example.kotlin.tc2007bexamandroid.framework.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.tc2007bexamandroid.data.network.country.Country
import com.example.kotlin.tc2007bexamandroid.data.network.country.CountryResponse
import com.example.kotlin.tc2007bexamandroid.domain.CountryListRequirement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//Adapt to new api
class MainViewModel: ViewModel() {
    val movieLiveData = MutableLiveData<CountryResponse>()
    private val movieListRequirement = CountryListRequirement()

    fun getMovieList(){
        viewModelScope.launch(Dispatchers.IO) {
            val result: CountryResponse? = movieListRequirement()
            Log.d("Salida", result?.total_results.toString())
            CoroutineScope(Dispatchers.Main).launch {
                movieLiveData.postValue(result!!)
            }
        }
    }
}