package com.dave.drapeaupays.data.api

import com.dave.drapeaupays.model.Country
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApi {
    @GET("all?fields=name,capital,cca2,flags,region")
    suspend fun getAllCountries(): List<Country>

    @GET("region/{region}?fields=name,capital,cca2,flags,region")
    suspend fun getCountriesByRegion(@Path("region") region: String): List<Country>

    companion object {
        fun create(): CountryApi {
            return Retrofit.Builder()
                .baseUrl("https://restcountries.com/v3.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CountryApi::class.java)
        }
    }
}
