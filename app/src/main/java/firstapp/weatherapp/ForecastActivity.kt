package firstapp.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ForecastActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    val temperature = listOf<ForecastTemp>(
        ForecastTemp(27F, 18F, 37F),
        ForecastTemp(35F, 34F, 36F),
        ForecastTemp(18F, 19F, 20F),
        ForecastTemp(33F,30F, 20F),
        ForecastTemp(17F, 20F, 19F),
        ForecastTemp(11F, 5F, 18F),
        ForecastTemp(19F,22F,24F),
        ForecastTemp(33F, 22F,35F),
        ForecastTemp(19F,22F,27F),
        ForecastTemp(20F, 18F, 31F),
        ForecastTemp(13F, 7F,20F),
        ForecastTemp(17F,11F,24F),
        ForecastTemp(28F,10F,30F),
        ForecastTemp(19F,8F,31F),
        ForecastTemp(33F,30F,36F),
        ForecastTemp(28F,10F,30F)


    )
     val adapterData = listOf<DayForecast>(
        DayForecast( 1644452968,1644452968,1571485599,temperature.get(0), 985F,61 ),
        DayForecast(1644539368,1644539368, 1644449564,temperature.get(1), 1015F, 59),
        DayForecast(1644625768, 1644625768,1644412964, temperature.get(2), 1005F, 71),
        DayForecast(1644712168, 1644712168,1644363104, temperature.get(3), 990F, 65),
        DayForecast(1644798568,1644798568, 1644363104, temperature.get(4), 1115F, 81),
        DayForecast(1644884968,1644884968, 1571485599, temperature.get(5),1005F, 57),
        DayForecast(1644971368, 1644971368,1644449564, temperature.get(6),989F, 64),
        DayForecast(1645057768,1645057768, 1644363104,temperature.get(7), 1005F, 70 ),
         DayForecast(1645144168,1645144168, 1571485599, temperature.get(8), 1005F, 56),
        DayForecast(1645230568,1645230568,1644363104,temperature.get(9),990F, 69 ),
         DayForecast(1645316968,1645316968,1571485599, temperature.get(10), 900F, 57),
         DayForecast(1645403368,1645403368,1644412964,temperature.get(11),1115F, 56),
        DayForecast(1645489768,1645489768, 1644363104, temperature.get(12), 1005F, 70),
        DayForecast(1645576168,1645576168,1644452968, temperature.get(13), 990F, 61),
        DayForecast(1645662568, 1645662568, 1644449564, temperature.get(14), 1005F,57),
        DayForecast(1645748968, 1645748968, 1571485599, temperature.get(15), 985F, 64)





    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        val actionBar = supportActionBar
        actionBar!!.title ="Forecast Activity"

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(adapterData)
    }
}