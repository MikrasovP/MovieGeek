package demo.movie.app.ui.recycler.adapters

import demo.movie.app.model.dto.CastMemberDto
import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.model.dto.tv.TvPreviewDto

abstract class BaseAdapterProvider {

    var onMovieClick: (MoviePreviewDto) -> Unit = {}

    var onTvSeriesClick: (TvPreviewDto) -> Unit = {}

    var onCastMemberClick: (CastMemberDto) -> Unit = {}

    abstract fun getPopularMoviesAdapter(): MovieAdapter

    abstract fun getTrendingMoviesAdapter(): MovieAdapter

    abstract fun getTopRatedMoviesAdapter(): MovieAdapter

    abstract fun getRecommendedMoviesAdapter(): MovieAdapter

    abstract fun getPopularTvSeriesAdapter(): TvSeriesAdapter

    abstract fun getTrendingTvSeriesAdapter(): TvSeriesAdapter

    abstract fun getTopRatedTvSeriesAdapter(): TvSeriesAdapter

    abstract fun getCastAdapter(): CastAdapter

}