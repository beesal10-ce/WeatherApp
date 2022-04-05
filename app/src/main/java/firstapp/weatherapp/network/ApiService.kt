package firstapp.weatherapp.network

import firstapp.weatherapp.model.WeatherResponseDTO
import firstapp.weatherapp.model.forecast.ForecastDTO
import firstapp.weatherapp.utils.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/weather")
    suspend fun getWeatherDetails(
        @Query("zip") zipCode: String,
        @Query("appid") appId:String = Constant.APP_ID
    ): Response<WeatherResponseDTO>


    @GET("data/2.5/forecast/daily")
    suspend fun getSixteenDaysForecast(
        @Query("lat") lat: Double,
        @Query("lon") long:Double,
        @Query("cnt") cnt:Int=16,
        @Query("appid") appId:String = Constant.APP_ID
    ): Response<ForecastDTO>

    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") long: Double,
        @Query("appid") appId: String = Constant.APP_ID
    ): Response<WeatherResponseDTO>


}