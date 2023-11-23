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
class MainViewModel(private val countryListRequirement: CountryListRequirement) : ViewModel() {
    val countriesLiveData = MutableLiveData<List<Country>>()

    fun getCountryData(date: String) {
        viewModelScope.launch(Dispatchers.IO) { // Llama a la red en el hilo IO.
            try {
                val countryData = countryListRequirement(date)
                CoroutineScope(Dispatchers.Main).launch { // Actualiza LiveData en el hilo principal.
                    countriesLiveData.value = countryData
                }
            } catch (e: Exception) {
                // Manejar la excepción, como un error de red.
            }
        }
    }
}

