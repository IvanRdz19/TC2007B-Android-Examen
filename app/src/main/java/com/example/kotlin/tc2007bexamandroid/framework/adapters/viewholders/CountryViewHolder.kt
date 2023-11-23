package com.example.kotlin.tc2007bexamandroid.framework.adapters.viewholders

import android.content.Context
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.tc2007bexamandroid.databinding.ItemCountryBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryViewHolder(private val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Result, context: Context){ //Error con result cambiar a cual
        binding.TVCountry.text = item.original_title

        // Limit the overview text to 30 characters and append "..." if it exceeds
        val overviewText = if (item.overview.length > 30) {
            "${item.overview.substring(0, 30)}..."
        } else {
            item.overview
        }
        binding.TVOverview.text = overviewText

        getCountryInfo(item.poster_path, binding.IVPhoto, context)
    }

    private fun getCountryInfo(url:String, imageView: ImageView, context: Context){

        CoroutineScope(Dispatchers.IO).launch {
            CoroutineScope(Dispatchers.Main).launch {
                val urlImage: String = "https://image.tmdb.org/t/p/original$url"

                val requestOptions =  RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .fitCenter()
                    .priority(Priority.HIGH)

                Glide.with(context).load(urlImage)
                    .apply(requestOptions)
                    .into(imageView)
            }
        }
    }
}