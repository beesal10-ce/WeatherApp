package firstapp.weatherapp

import com.squareup.moshi.Json


data class DayForecast (
    val forecasttemp:Float,
            @Json(name="feels_like") val feelsLike: Float,
                    @Json(name="temp_min") val forecastMin: Float,
                            @Json(name = "temp_max")val forecastMax:Float,
    val pressure : Float,
    val humidity: Float,

)