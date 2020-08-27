package demo.movie.app.model.dto.tv

import com.google.gson.annotations.SerializedName

data class TvPreviewDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("name")
    val title: String,
    @SerializedName("original_name")
    val original_name: String,
    @SerializedName("first_air_date")
    val release_date: String,
    @SerializedName("poster_path")
    val poster_path: String
)