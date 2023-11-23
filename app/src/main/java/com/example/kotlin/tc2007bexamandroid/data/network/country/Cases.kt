package com.example.kotlin.tc2007bexamandroid.data.network.country

import com.google.gson.annotations.SerializedName

//Data class for cases (object inside Country)
data class Cases (
    @SerializedName("total") val total: Int,
    @SerializedName("new") val new: Int,
)