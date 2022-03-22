package firstapp.weatherapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import firstapp.weatherapp.model.WeatherResponseDTO
import firstapp.weatherapp.repository.SearchRepository
import firstapp.weatherapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrentConditionViewModel @Inject constructor(private val searchRepository: SearchRepository): ViewModel() {

    private val _weather = MutableLiveData<Resource<WeatherResponseDTO>>()
    val weather: LiveData<Resource<WeatherResponseDTO>> = _weather


}