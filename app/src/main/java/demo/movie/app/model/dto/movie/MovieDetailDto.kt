package demo.movie.app.model.dto.movie

import com.google.gson.annotations.SerializedName
import demo.movie.app.model.dto.Credits
import demo.movie.app.model.dto.Genre
import demo.movie.app.model.dto.MovieStatus

data class MovieDetailDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("runtime")
    val runtime: Int?,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("credits")
    val credits: Credits,
    @SerializedName("recommendations")
    val recommendations: MoviesResponseResult,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("status")
    val status: MovieStatus,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("revenue")
    val revenue: Int,
    @SerializedName("adult")
    val isAdult: Boolean
)