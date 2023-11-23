package com.example.kotlin.tc2007bexamandroid.data

import com.example.kotlin.tc2007bexamandroid.data.network.CountryAPIClient
import com.example.kotlin.tc2007bexamandroid.data.network.country.Country

class CountryRepository {
    private val apiCountry = CountryAPIClient()

    // Añade un parámetro de fecha al método.
    suspend fun getCountryList(date: String): List<Country>? {
        // Pasa la fecha al método del cliente de la API.
        return apiCountry.getCountryList(date)
    }
}
