package com.example.weatherforcastapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.chromium.base.Callback
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



// 289d32a81f7840810f86b4abe802db37



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchWeatherData()

    }

    private fun fetchWeatherData() {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .build().create(ApiInterface::class.java)
        val response = retrofit.getweatherData("pune","289d32a81f7840810f86b4abe802db37","metrics")
        response.enqueue(object :Callback<WeatherApp>, retrofit2.Callback<WeatherApp> {
            override fun onResult(result: WeatherApp?) {

            }

            override fun onResponse(call: Call<WeatherApp>, response: Response<WeatherApp>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody !=null){
                    val temperature = responseBody.main.temp.toString()
                    
                    //Log.d("TAG","onResponse: $temperature")
                }

            }

            override fun onFailure(call: Call<WeatherApp>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}

