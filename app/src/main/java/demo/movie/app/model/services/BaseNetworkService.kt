package demo.movie.app.model.services

import demo.movie.app.model.dto.MoviePreviewDto
import io.reactivex.rxjava3.core.Observable

interface BaseNetworkService {

    fun getPopularMovies(): Observable<List<MoviePreviewDto>>

    fun getTrendingPerWeek(): Observable<List<MoviePreviewDto>>

    fun getTrendingPerDay(): Observable<List<MoviePreviewDto>>

    fun getTopRated(): Observable<List<MoviePreviewDto>>

}