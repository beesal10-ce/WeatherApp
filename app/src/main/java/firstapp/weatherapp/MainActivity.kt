package firstapp.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button




    private lateinit var conditionIcon :ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    conditionIcon =findViewById(R.id.condition_icon)

        button  = findViewById(R.id.button)

        button.setOnClickListener{
            startActivity(Intent(this, ForecastActivity::class.java))
        }
    }
}