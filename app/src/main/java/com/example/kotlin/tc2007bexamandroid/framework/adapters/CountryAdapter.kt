package com.example.kotlin.tc2007bexamandroid.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.tc2007bexamandroid.data.network.country.Country
import com.example.kotlin.tc2007bexamandroid.databinding.ItemCountryBinding
import com.example.kotlin.tc2007bexamandroid.framework.adapters.viewholders.CountryViewHolder

class CountryAdapter: RecyclerView.Adapter<CountryViewHolder>() {
    var data:ArrayList<Result> = ArrayList()
    lateinit var context: Context

    fun CountryAdapter(basicData: List<Result>, context: Context){
        this.data = basicData as ArrayList<Result>
        this.context = context
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CountryViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return data.size
    }
}