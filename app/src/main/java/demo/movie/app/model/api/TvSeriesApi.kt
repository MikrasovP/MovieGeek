package demo.movie.app.model.api

import demo.movie.app.model.dto.tv.TvResponseResult
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TvSeriesApi {
    @GET("/tv/popular")
    fun getPopular(
        @Query("api_key") api_key: String
    ): Observable<TvResponseResult>

    @GET("trending/tv/day")
    fun getTrendingPerDay(
        @Query("api_key") api_key: String
    ): Observable<TvResponseResult>

    @GET("trending/tv/week")
    fun getTrendingPerWeek(
        @Query("api_key") api_key: String
    ): Observable<TvResponseResult>

    @GET("tv/top_rated")
    fun getTopRated(
        @Query("api_key") api_key: String
    ): Observable<TvResponseResult>
}