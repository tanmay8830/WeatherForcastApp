package com.example.weatherforcastapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("weather")
    fun getweatherData(
        @Query("q") city:String,
        @Query("appid") appid :String,
        @Query("units") units :String
    ):Call<WeatherApp>
}