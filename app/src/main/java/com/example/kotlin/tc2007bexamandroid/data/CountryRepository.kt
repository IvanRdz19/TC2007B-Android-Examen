package com.example.kotlin.tc2007bexamandroid.data

import com.example.kotlin.tc2007bexamandroid.data.network.CountryAPIClient
import com.example.kotlin.tc2007bexamandroid.data.network.country.Country

class CountryRepository {
    private val apiCountry = CountryAPIClient()

    // Add date parameter to getCountryList method.
    suspend fun getCountryList(date: String): List<Country>? {
        return apiCountry.getCountryListByDate(date)
    }
}
