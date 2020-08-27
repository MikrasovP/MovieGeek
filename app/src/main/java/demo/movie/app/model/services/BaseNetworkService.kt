package demo.movie.app.model.services

import demo.movie.app.model.dto.movie.MoviesResponseResult
import io.reactivex.rxjava3.core.Observable

interface BaseNetworkService {

    fun getPopularMovies(): Observable<MoviesResponseResult>

    fun getTrendingPerWeek(): Observable<MoviesResponseResult>

    fun getTrendingPerDay(): Observable<MoviesResponseResult>

    fun getTopRated(): Observable<MoviesResponseResult>

}