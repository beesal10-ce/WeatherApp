package firstapp.weatherapp.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WindDTO(
    val deg: Int,
    val speed: Double
):Parcelable