package com.example.kotlin.tc2007bexamandroid.domain

import com.example.kotlin.tc2007bexamandroid.data.CountryRepository
import com.example.kotlin.tc2007bexamandroid.data.network.country.Country

//Class for getting the list of countries
class CountryListRequirement {
    private val repository = CountryRepository()

    suspend operator fun invoke(date: String): List<Country>? {
        return repository.getCountryList(date)
    }
}
