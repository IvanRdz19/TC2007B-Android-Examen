package com.example.kotlin.tc2007bexamandroid.framework.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.tc2007bexamandroid.data.network.country.Country
import com.example.kotlin.tc2007bexamandroid.domain.CountryListRequirement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val countryListRequirement: CountryListRequirement) : ViewModel() {
    val countriesLiveData = MutableLiveData<List<Country>>()

    fun getCountryData(date: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result: List<Country>? = countryListRequirement(date) //Fetch country data
                launch(Dispatchers.Main) {
                    result?.let {
                        countriesLiveData.postValue(it) //Update the live data
                    } ?: run {
                        // Handle null case
                    }
                }
            } catch (e: Exception) {
                // Handle exception
            }
        }
    }
}
