package com.gaur.weatherapp.repository

import firstapp.weatherapp.model.WeatherResponseDTO
import firstapp.weatherapp.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class  CurrentConditionRepo @Inject constructor(private val apiService: ApiService) {


    suspend fun getCurrentLocationWeather(lat: Double, long: Double): Response<WeatherResponseDTO> {
        return apiService.getCurrentWeather(lat, long)
    }

}