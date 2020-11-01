package demo.movie.app.model.repo.tv

import demo.movie.app.model.dto.tv.TvDetailDto
import demo.movie.app.model.dto.tv.TvResponseResult
import io.reactivex.rxjava3.core.Observable

interface BaseTvRepo {

    fun getPopular(): Observable<TvResponseResult>

    fun getTrendingPerWeek(): Observable<TvResponseResult>

    fun getTrendingPerDay(): Observable<TvResponseResult>

    fun getTopRated(): Observable<TvResponseResult>

    fun getTvDetails(id:Int): Observable<TvDetailDto>
}