package firstapp.weatherapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import firstapp.weatherapp.ErrorDialogFragment
import firstapp.weatherapp.MainActivity
import firstapp.weatherapp.MainViewModelSearch
import firstapp.weatherapp.R
import firstapp.weatherapp.databinding.ActivityMainBinding


class Search : AppCompatActivity() {
    private lateinit var mainViewModelSearch: MainViewModelSearch
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        mainViewModelSearch = MainViewModelSearch()
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


            mainViewModelSearch.showErrorDialog.observe(this) { showError ->
                if (showError) {
                    ErrorDialogFragment().show(supportFragmentManager, ErrorDialogFragment.TAG)
                }
            }

            binding.cityName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


                }

                override fun afterTextChanged(p0: Editable?) {
                    5
                }

            })
            binding.BT.setOnClickListener {}
            mainViewModelSearch.submitButtonClicked()

        }
    }
}



