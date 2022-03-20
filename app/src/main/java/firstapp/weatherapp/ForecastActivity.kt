package firstapp.weatherapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import firstapp.weatherapp.ForecastConditions as ForecastConditions
class ForecastActivity: AppCompatActivity() {
    private val apiKey ="51048e1180bda3dcbd240c9d9051920e"

    private lateinit var api: Api
    private lateinit var cityName: TextView
    private lateinit var forecastTemp: TextView

    private lateinit var conditionIcon : ImageView
    private lateinit var feelsLike: TextView
    private lateinit var forecastMin:TextView
    private lateinit var forecastMax: TextView
    private lateinit var pressure: TextView
    private lateinit var humidity: TextView
    private lateinit var Sunrise: TextView
    private lateinit var Sunset: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        forecastTemp = findViewById(R.id.temperature)
        conditionIcon = findViewById(R.id.sun)
        forecastMin = findViewById(R.id.low)
        forecastMax = findViewById(R.id.high)
        Sunrise = findViewById(R.id.sunrise)
        Sunset = findViewById(R.id.sunset)
        feelsLike = findViewById(R.id.feels_like)

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http//api.openweathermap.org/data/2.5/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        api = retrofit.create(api::class.java)

    }
    override fun onResume(){
        super.onResume()

        val call:Call<ForecastConditions> = api.getForecastConditions("55331")
        call.enqueue(object : Callback<ForecastConditions>{
            override fun onResponse(
                call:Call<ForecastConditions>,
                response: Response<ForecastConditions>
            ) {
                val forecastConditions = response.body()
                forecastConditions?.let {
                    bindData(it)
                }
            }

            override fun onFailure(call: Call<ForecastConditions>, t:Throwable){

            }
        })

    }

    private fun bindData(forecastConditions: ForecastConditions) {
        cityName.text = forecastConditions.name
        findViewById<TextView>(R.id.temperature).text = forecastTemp.toString()
        findViewById<TextView>(R.id.low).text = forecastMin.toString()
        findViewById<TextView>(R.id.high).text = forecastMax.toString()

        findViewById<TextView>(R.id.Pressure).text = pressure.toString()
        findViewById<TextView>(R.id.humidity).text = humidity.toString()

        val iconName = forecastConditions.weather.firstOrNull()?.icon
        val iconUrl = "https://openweathermap.org/img/wn/${iconName}@2x.png"
        Glide.with(this)
            .load(iconUrl)
            .into(conditionIcon)
    }

    }
