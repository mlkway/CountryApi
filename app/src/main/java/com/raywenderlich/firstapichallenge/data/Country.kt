package com.raywenderlich.firstapichallenge.data

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val name: String,
    @SerializedName("capital")
    val capital: String,
    @SerializedName("flag")
    val flag: String)