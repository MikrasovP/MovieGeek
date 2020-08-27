package demo.movie.app.model.dto.movie

import com.google.gson.annotations.SerializedName
import demo.movie.app.model.dto.movie.MoviePreviewDto

data class MoviesResponseResult(
    @SerializedName("results")
    val results: List<MoviePreviewDto>
)