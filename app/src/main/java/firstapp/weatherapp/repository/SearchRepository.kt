package firstapp.weatherapp.repository

import firstapp.weatherapp.model.WeatherResponseDTO
import firstapp.weatherapp.model.forecast.ForecastDTO
import firstapp.weatherapp.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class SearchRepository @Inject constructor(private val apiService: ApiService) {


    suspend fun getWeather(zipCode:String): Response<WeatherResponseDTO> {
        return apiService.getWeatherDetails(zipCode)
    }


}