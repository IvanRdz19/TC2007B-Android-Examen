package com.example.kotlin.tc2007bexamandroid.data.network

import com.example.kotlin.tc2007bexamandroid.data.network.country.Country
import com.example.kotlin.tc2007bexamandroid.data.network.country.CountryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CountryAPIService {
    @GET("covid19") //Get request to get country data by date
    suspend fun getCountryDataByDate(
        @Query("date") date: String,
        @Header("X-Api-Key") apiKey: String
    ): Response<List<Country>>
}
