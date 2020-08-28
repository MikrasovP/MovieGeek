package demo.movie.app.model.dto.movie

import com.google.gson.annotations.SerializedName

data class MoviesResponseResult(
    @SerializedName("results")
    val results: List<MoviePreviewDto>
)