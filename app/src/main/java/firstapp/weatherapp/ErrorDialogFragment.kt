package firstapp.weatherapp

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import firstapp.weatherapp.DaggerWeatherApplication_HiltComponents_SingletonC.builder


class ErrorDialogFragment:DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage("Error  data")
            .setPositiveButton("Ok",null)
            .create()
    companion object {
        const val TAG = "ErrorDialogFragment"
    }


    }
