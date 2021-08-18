package br.com.joselaine.tvseriesandmovies.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Detail(
    @SerializedName("backdrop_path")
    val backdrop_path: String?,
    @SerializedName("first_air_date")
    val first_air_date: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("in_production")
    val in_production: Boolean,
    @SerializedName("last_air_date")
    val last_air_date: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("number_of_episodes")
    val number_of_episodes: Int,
    @SerializedName("number_of_seasons")
    val number_of_seasons: Int,
    @SerializedName("original_name")
    val original_name: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val poster_path: String?,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("vote_average")
    val vote_average: Double,
    @SerializedName("vote_count")
    val vote_count: Int
) : Parcelable {
    constructor() : this("", "",0,false,"","",0,0,"","", 0.0,"", "", "", 0.0,0)
}