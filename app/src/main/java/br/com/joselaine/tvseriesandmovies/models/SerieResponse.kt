package br.com.joselaine.tvseriesandmovies.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SerieResponse(
    @SerializedName("results")
    val series : List<Serie>
) : Parcelable {
    constructor() : this(mutableListOf())
}