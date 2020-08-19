package demo.movie.app.model.dto

import com.google.gson.annotations.SerializedName

data class MoviesResponseResult(
    @SerializedName("results")
    val results: List<MoviePreviewDto>
)