package demo.movie.app.model.repo.movies

import demo.movie.app.model.dto.movie.MoviesResponseResult
import io.reactivex.rxjava3.core.Observable

interface BaseMoviesRepo {

    fun getPopular(): Observable<MoviesResponseResult>

    fun getTrendingPerWeek(): Observable<MoviesResponseResult>

    fun getTrendingPerDay(): Observable<MoviesResponseResult>

    fun getTopRated(): Observable<MoviesResponseResult>

}