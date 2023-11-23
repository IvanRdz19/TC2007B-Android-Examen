package com.example.kotlin.tc2007bexamandroid.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin.tc2007bexamandroid.databinding.ActivityMainBinding
import com.example.kotlin.tc2007bexamandroid.framework.adapters.CountryAdapter
import com.example.kotlin.tc2007bexamandroid.framework.viewmodels.MainViewModel
import com.example.kotlin.tc2007bexamandroid.framework.viewmodels.MainViewModelFactory
import com.example.kotlin.tc2007bexamandroid.domain.CountryListRequirement

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter: CountryAdapter = CountryAdapter(listOf())

    private val viewModel: MainViewModel by viewModels { MainViewModelFactory(CountryListRequirement()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        viewModel.getCountryData("2021-03-10") // Ejemplo de fecha
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RVCountry.setHasFixedSize(true)
        binding.RVCountry.layoutManager = GridLayoutManager(this, 2)
        binding.RVCountry.adapter = adapter
    }

    private fun initializeObservers() {
        viewModel.countriesLiveData.observe(this) { countries ->
            adapter.updateCountries(countries)
        }
    }
}
