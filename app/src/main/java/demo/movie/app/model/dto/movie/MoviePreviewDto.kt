package demo.movie.app.model.dto.movie

import com.google.gson.annotations.SerializedName

data class MoviePreviewDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("adult")
    val isAdult: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("title")
    val title: String,
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    val posterPath: String
)