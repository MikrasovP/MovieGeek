package demo.movie.app.model.dto.tv

import com.google.gson.annotations.SerializedName

data class TvResponseResult(
    @SerializedName("results")
    val results: List<TvPreviewDto>
)