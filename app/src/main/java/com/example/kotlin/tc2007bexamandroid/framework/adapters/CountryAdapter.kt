package com.example.kotlin.tc2007bexamandroid.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.tc2007bexamandroid.R
import com.example.kotlin.tc2007bexamandroid.data.network.country.Country
import com.example.kotlin.tc2007bexamandroid.databinding.ItemCountryBinding
import com.example.kotlin.tc2007bexamandroid.framework.adapters.viewholders.CountryViewHolder

class CountryAdapter(private var countries: List<Country>) : RecyclerView.Adapter<CountryViewHolder>() {
    //Inflates the item view and returns a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }
    //Binds data to the viewholder
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }
    //Returns the total number of items in the data set
    override fun getItemCount(): Int = countries.size
    //Updates the list of countries and notifies the adapter the change
    fun updateCountries(newCountries: List<Country>) {
        countries = newCountries
        notifyDataSetChanged()
    }
}