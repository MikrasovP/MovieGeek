package demo.movie.app.model.dto.tv

import com.google.gson.annotations.SerializedName
import demo.movie.app.model.dto.Credits
import demo.movie.app.model.dto.Genre

data class TvDetailDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_name")
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("last_air_date")
    val lastAirDate: String,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("episode_run_time")
    val episodeRuntime: List<Int>,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("credits")
    val credits: Credits,
    @SerializedName("recommendations")
    val recommendations: TvResponseResult,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("status")
    val status: String,
)