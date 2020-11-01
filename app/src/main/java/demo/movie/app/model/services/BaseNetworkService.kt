package demo.movie.app.model.services

import demo.movie.app.model.dto.movie.MovieDetailDto
import demo.movie.app.model.dto.movie.MoviesResponseResult
import demo.movie.app.model.dto.tv.TvDetailDto
import demo.movie.app.model.dto.tv.TvResponseResult
import io.reactivex.rxjava3.core.Observable

interface BaseNetworkService {

    fun getPopularMovies(): Observable<MoviesResponseResult>

    fun getTrendingPerWeekMovies(): Observable<MoviesResponseResult>

    fun getTrendingPerDayMovies(): Observable<MoviesResponseResult>

    fun getTopRatedMovies(): Observable<MoviesResponseResult>

    fun getMovieDetails(id: Int): Observable<MovieDetailDto>

    fun getPopularTv() : Observable<TvResponseResult>

    fun getTrendingPerDayTv() : Observable<TvResponseResult>

    fun getTrendingPerWeekTv() : Observable<TvResponseResult>

    fun getTopRatedTv() : Observable<TvResponseResult>

    fun getTvDetails(id: Int): Observable<TvDetailDto>

}