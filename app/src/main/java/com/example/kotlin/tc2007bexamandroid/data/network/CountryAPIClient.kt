package com.example.kotlin.tc2007bexamandroid.data.network

import com.example.kotlin.tc2007bexamandroid.data.network.country.Country
import com.example.kotlin.tc2007bexamandroid.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Class handles the API client for fetching country data
class CountryAPIClient {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: CountryAPIService = retrofit.create(CountryAPIService::class.java)

    // Get all countries of a given date
    suspend fun getCountryListByDate(date: String): List<Country>? {
        return try {
            val response = api.getCountryDataByDate(date, Constants.TOKEN)
            if (response.isSuccessful) {
                response.body()
            } else {
                // Error handling
                null
            }
        } catch (e: Exception) {
            // Exception handling
            e.printStackTrace()
            null
        }
    }
}