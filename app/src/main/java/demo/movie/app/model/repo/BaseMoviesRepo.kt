package demo.movie.app.model.repo

import demo.movie.app.model.dto.MoviePreviewDto
import demo.movie.app.model.dto.MoviesResponseResult
import io.reactivex.rxjava3.core.Observable

interface BaseMoviesRepo {

    fun getPopularMovies(): Observable<MoviesResponseResult>

    fun getTrendingPerWeek(): Observable<MoviesResponseResult>

    fun getTrendingPerDay(): Observable<MoviesResponseResult>

    fun getTopRated(): Observable<MoviesResponseResult>

}