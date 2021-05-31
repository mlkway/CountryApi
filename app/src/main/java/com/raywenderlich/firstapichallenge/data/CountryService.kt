package com.raywenderlich.firstapichallenge.data

import retrofit2.Response
import retrofit2.http.GET

interface CountryService {


    @GET("all")
    suspend fun getAllData(): Response<List<Country>>

}