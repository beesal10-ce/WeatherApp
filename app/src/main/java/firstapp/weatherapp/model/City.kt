package firstapp.weatherapp.model

import firstapp.weatherapp.model.forecast.Coord

data class City(
    val coord: Coord,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val timezone: Int
)













