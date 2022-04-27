package firstapp.weatherapp.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import firstapp.weatherapp.databinding.ViewHolderForecastBinding
import firstapp.weatherapp.model.forecast.WeatherDTO
import firstapp.weatherapp.utils.convertIntoDate
import firstapp.weatherapp.utils.convertMilliTime
import firstapp.weatherapp.utils.formatUptoTwoDecimal
import java.time.Instant
import firstapp.weatherapp.databinding.ViewHolderForecastBinding.inflate as inflate1

class ForecastWeatherAdapter(private val list: List<WeatherDTO>) :
    RecyclerView.Adapter<ForecastWeatherAdapter.MyViewHolder>() {
    inner class MyViewHolder(val viewDataBinding: ViewHolderForecastBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ForecastWeatherAdapter.MyViewHolder {
        val binding = inflate1(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ForecastWeatherAdapter.MyViewHolder, position: Int) {

        val binding = holder.viewDataBinding
        val it = this.list[position]
        binding.tvTemp.text =
            "Temp " + formatUptoTwoDecimal(it.feels_like.day.minus(273)*9/5 +32) + "\u2109"
        binding.tvHighTemp.text = "High " + formatUptoTwoDecimal(it.temp.max.minus(273)*9/5 +32) + "\u2109"
        binding.tvLowTemp.text = "Low " + formatUptoTwoDecimal(it.temp.min.minus(273)*9/5 +32) + "\u2109"
        binding.tvSunrise.text = "Sunrise: " + convertMilliTime(it.sunrise.toLong())
        binding.tvSunset.text = "Sunset: " + convertMilliTime(it.sunset.toLong())
        binding.tvDate.text = convertIntoDate(it.dt.toLong())


        Glide.with(binding.ivCircle)
            .load("https://openweathermap.org/img/wn/${it.weather[0].icon}@2x.png")
            .into(binding.ivCircle)


    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}