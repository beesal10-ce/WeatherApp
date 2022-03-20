package firstapp.weatherapp;

import android.content.Intent

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

import dagger.hilt.android.AndroidEntryPoint
import firstapp.weatherapp.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @Inject lateinit var viewModel: MainViewModel

    private val apiKey = "51048e1180bda3dcbd240c9d9051920e"
    private lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = findViewById<Button>(R.id.BT)
        button.setOnClickListener {
            val intent = Intent(this, Forecast::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.currentConditions.observe(this) { currentConditions ->
            bindData(currentConditions)

        }
        viewModel.loadData()

    }

    private fun bindData(currentConditions: CurrentConditions) {
        binding.cityName.text = currentConditions.name
        binding.temperature.text =
            getString(R.string.temperature, currentConditions.main.temp.toInt())
        binding.feelsLike.text =
            getString(R.string.feels_like, currentConditions.main.feelsLike.toInt())
        binding.low.text = getString(R.string.low, currentConditions.main.tempMin.toInt())
        binding.high.text = getString(R.string.high, currentConditions.main.tempMax.toInt())
        binding.humidity.text =
            getString(R.string.humidity, currentConditions.main.humidity.toInt())
        binding.Pressure.text =
            getString(R.string.Pressure, currentConditions.main.pressure.toInt())
        val iconName = currentConditions.weather.firstOrNull()?.icon
        val iconUrl = "https://openweathermap.org/img/wn/${iconName}@2x.png"
        Glide.with(this)
            .load(iconUrl)
            .into(binding.conditionIcon)

    }
}