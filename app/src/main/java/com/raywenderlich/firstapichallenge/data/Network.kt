package com.raywenderlich.firstapichallenge.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    val apiService: CountryService = Retrofit.Builder()
        .baseUrl("https://restcountries.eu/rest/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CountryService::class.java)




}