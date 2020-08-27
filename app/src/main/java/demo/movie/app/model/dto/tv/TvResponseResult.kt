package demo.movie.app.model.dto.tv

import com.google.gson.annotations.SerializedName
import demo.movie.app.model.dto.movie.MoviePreviewDto

data class TvResponseResult(
    @SerializedName("results")
    val results: List<TvPreviewDto>
)