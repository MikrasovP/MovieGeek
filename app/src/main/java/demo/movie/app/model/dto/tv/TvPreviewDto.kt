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
    val originalName: String,
    @SerializedName("first_air_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    val posterPath: String?
)