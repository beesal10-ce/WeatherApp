package firstapp.weatherapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class MyAdapter(private val data: List<DayForecast>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    @SuppressLint("NewApi")
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        private val dateView: TextView = view.findViewById(R.id.date)
        private val sunriseView: TextView = view.findViewById(R.id.sunrise)
        private val sunsetView: TextView = view.findViewById(R.id.sunset)
        private val temp : TextView = view.findViewById(R.id.temp)
        private val tempHigh : TextView = view.findViewById(R.id.tempHigh)
        private val tempLow : TextView = view.findViewById(R.id.tempLow)
        private val dateFormatter = DateTimeFormatter.ofPattern("MMM dd")
        private val timeFormatter = DateTimeFormatter.ofPattern("h:mma")

        fun bind(dayForecast: DayForecast) {
           // val instant = Instant.ofEpochSecond(data.date)
            val dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(dayForecast.date), ZoneId.systemDefault())
            val sunrise = LocalDateTime.ofInstant(Instant.ofEpochSecond(dayForecast.sunrise), ZoneId.systemDefault())
            val sunset = LocalDateTime.ofInstant(Instant.ofEpochSecond(dayForecast.sunset), ZoneId.systemDefault())
            dateView.text = dateFormatter.format(dateTime)
            sunriseView.append(timeFormatter.format(sunrise))
            sunsetView.append(timeFormatter.format(sunset))
            temp.append(dayForecast.temp.max.toInt().toString() + "°")
            tempHigh.append(dayForecast.temp.max.toInt().toString()+ "°")
            tempLow.append(dayForecast.temp.min.toInt().toString()+ "°")
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_date,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount()= data.size
}