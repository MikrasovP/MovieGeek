package demo.movie.app.ui.discover.recycler.adapters

import demo.movie.app.model.dto.movie.MoviePreviewDto

abstract class BaseAdapterProvider {
    var onMovieClick: (MoviePreviewDto) -> Unit = {}

    abstract fun getPopularMoviesAdapter(): MovieAdapter

    abstract fun getTrendingMoviesAdapter(): MovieAdapter

    abstract fun getTopRatedMoviesAdapter(): MovieAdapter

}