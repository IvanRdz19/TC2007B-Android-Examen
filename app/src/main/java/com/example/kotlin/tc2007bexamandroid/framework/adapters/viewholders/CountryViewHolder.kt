package com.example.kotlin.tc2007bexamandroid.framework.adapters.viewholders

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.tc2007bexamandroid.R
import com.example.kotlin.tc2007bexamandroid.data.network.country.Country
import com.example.kotlin.tc2007bexamandroid.databinding.ItemCountryBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val countryNameTextView: TextView = itemView.findViewById(R.id.TVCountry)
    private val countryRegionTextView: TextView = itemView.findViewById(R.id.TVRegion)
    private val casesTotalTextView: TextView = itemView.findViewById(R.id.TVTotalCases)
    private val casesNewTextView: TextView = itemView.findViewById(R.id.TVNewCases)

    //Binds data from a Country object to the view in the viewholder
    fun bind(country: Country) {
        countryNameTextView.text = country.country
        countryRegionTextView.text = country.region
        casesTotalTextView.text = "Total cases: ${country.cases.total}"
        casesNewTextView.text = "New cases: ${country.cases.new}"
    }
}
