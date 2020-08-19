package demo.movie.app.model.dto

import com.google.gson.annotations.SerializedName

data class MoviePreviewDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("original_name")
    val original_name: String,
    @SerializedName("first_air_date")
    val firs_air_date: String,
    @SerializedName("poster_path")
    val poster_path: String
)