package firstapp.weatherapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CloudsDTO(
    val all: Int
):Parcelable