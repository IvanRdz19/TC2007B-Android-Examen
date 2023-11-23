package com.example.kotlin.tc2007bexamandroid.data.network

import com.example.kotlin.tc2007bexamandroid.data.network.country.Country
import retrofit2.http.GET
import retrofit2.http.Header

interface CountryAPIService {
    @GET("date")
    suspend fun getCountryList(@Header("Authorization") token: String): Country
}