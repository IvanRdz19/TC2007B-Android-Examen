package com.example.kotlin.tc2007bexamandroid.framework.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin.tc2007bexamandroid.domain.CountryListRequirement

class MainViewModelFactory(private val countryListRequirement: CountryListRequirement) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(countryListRequirement) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
