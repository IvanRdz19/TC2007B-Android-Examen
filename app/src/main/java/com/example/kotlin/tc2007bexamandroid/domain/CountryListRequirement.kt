package com.example.kotlin.tc2007bexamandroid.domain

import com.example.kotlin.tc2007bexamandroid.data.CountryRepository
import com.example.kotlin.tc2007bexamandroid.data.network.country.Country

class CountryListRequirement {
    private val repository = CountryRepository()

    suspend operator fun invoke(): Country? = repository.getCountryList()
}