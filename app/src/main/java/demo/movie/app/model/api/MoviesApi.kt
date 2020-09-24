package demo.movie.app.model.api

import demo.movie.app.model.dto.movie.MovieDetailDto
import demo.movie.app.model.dto.movie.MoviesResponseResult
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/popular")
    fun getPopular(
        @Query("api_key") api_key: String
    ): Observable<MoviesResponseResult>

    @GET("trending/movie/day")
    fun getTrendingPerDay(
        @Query("api_key") api_key: String
    ): Observable<MoviesResponseResult>

    @GET("trending/movie/week")
    fun getTrendingPerWeek(
        @Query("api_key") api_key: String
    ): Observable<MoviesResponseResult>

    @GET("movie/top_rated")
    fun getTopRated(
        @Query("api_key") api_key: String
    ): Observable<MoviesResponseResult>

    @GET("movie/{movie_id}")
    fun getMovie(
        @Path("movie_id") movieId: Int
    ): Observable<MovieDetailDto>

}