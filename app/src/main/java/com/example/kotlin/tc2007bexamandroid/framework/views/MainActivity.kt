package com.example.kotlin.tc2007bexamandroid.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin.tc2007bexamandroid.databinding.ActivityMainBinding
import com.example.kotlin.tc2007bexamandroid.framework.adapters.CountryAdapter
import com.example.kotlin.tc2007bexamandroid.framework.viewmodels.MainViewModel


class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter: CountryAdapter = CountryAdapter(listOf()) // Ajustado a CountryAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        viewModel.getCountryData("2022-03-10") // Ejemplo de fecha
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
