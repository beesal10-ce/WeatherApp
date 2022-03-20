package firstapp.weatherapp


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("weather")
    fun getCurrentConditions(

        @Query("zip" )zip:String,
        @Query("units")units:String ="imperial",
        @Query("appid")appId:String="51048e1180bda3dcbd240c9d9051920e"

    ) : CurrentConditions

        @GET("forecast daily")
     fun getForecastConditions(
         @Query("zip") zip:String,
         @Query("units")units: String="imperial",
         @Query("cnt") cnt: String ="51048e1180bda3dcbd240c9d9051920e"
     ):Call<ForecastConditions>


}