package com.example.kotlin.tc2007bexamandroid.data.network

import com.example.kotlin.tc2007bexamandroid.data.network.country.Country
import com.example.kotlin.tc2007bexamandroid.utils.Constants

class CountryAPIClient {
    private lateinit var api: CountryAPIService

    suspend fun getCountryList(date: String): Country?{
        api = NetworkModuleDI()
        return try{
            api.getCountryList("Bearer ${Constants.TOKEN}")
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}