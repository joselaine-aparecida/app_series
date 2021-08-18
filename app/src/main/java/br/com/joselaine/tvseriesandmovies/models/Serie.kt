package br.com.joselaine.tvseriesandmovies.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Serie(
    @SerializedName("id")
    val id : String ?,

    @SerializedName("name")
    val title : String?,

    @SerializedName("poster_path")
    val poster_path : String?,

    @SerializedName("overview")
    val overview : String?,

    @SerializedName("backdrop_path")
    val backdrop_path : String?,

    @SerializedName("vote_average")
val vote_average : Double?,

    @SerializedName("original_name")
    val original_name : String?,

    ) : Parcelable{
    constructor() : this("", "", "","","",0.0,"")
}