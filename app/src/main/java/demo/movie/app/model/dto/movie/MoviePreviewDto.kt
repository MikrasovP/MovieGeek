package demo.movie.app.model.dto.movie

import com.google.gson.annotations.SerializedName

data class MoviePreviewDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("title")
    val title: String,
    @SerializedName("original_name")
    val original_name: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("poster_path")
    val poster_path: String
)