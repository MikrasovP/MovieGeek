package demo.movie.app.ui.recycler.adapters

import demo.movie.app.util.image.BaseImageLoader
import javax.inject.Inject

class AdapterProvider @Inject constructor() : BaseAdapterProvider() {

    private var adapterPopularMovies: MovieAdapter? = null

    private var adapterTrendingMovies: MovieAdapter? = null

    private var adapterTopRatedMovies: MovieAdapter? = null

    private var adapterRecommendedMovies: MovieAdapter? = null

    private var adapterPopularTvSeries: TvSeriesAdapter? = null

    private var adapterTrendingTvSeries: TvSeriesAdapter? = null

    private var adapterTopRatedTvSeries: TvSeriesAdapter? = null

    @Inject
    lateinit var imageLoader: BaseImageLoader

    override fun getPopularMoviesAdapter(): MovieAdapter =
        if (adapterPopularMovies == null) {
            val adapter = MovieAdapter(onMovieClick, imageLoader)
            adapterPopularMovies = adapter
            adapter
        } else {
            adapterPopularMovies as MovieAdapter
        }

    override fun getTrendingMoviesAdapter(): MovieAdapter =
        if (adapterTrendingMovies == null) {
            val adapter = MovieAdapter(onMovieClick, imageLoader)
            adapterTrendingMovies = adapter
            adapter
        } else {
            adapterTrendingMovies as MovieAdapter
        }

    override fun getTopRatedMoviesAdapter(): MovieAdapter =
        if (adapterTopRatedMovies == null) {
            val adapter = MovieAdapter(onMovieClick, imageLoader)
            adapterTopRatedMovies = adapter
            adapter
        } else {
            adapterTopRatedMovies as MovieAdapter
        }

    override fun getRecommendedMoviesAdapter(): MovieAdapter =
        if (adapterRecommendedMovies == null) {
            val adapter = MovieAdapter(onMovieClick, imageLoader)
            adapterRecommendedMovies = adapter
            adapter
        } else {
            adapterRecommendedMovies as MovieAdapter
        }


    override fun getPopularTvSeriesAdapter(): TvSeriesAdapter =
        if (adapterPopularTvSeries == null) {
            val adapter = TvSeriesAdapter(onTvSeriesClick, imageLoader)
            adapterPopularTvSeries = adapter
            adapter
        } else {
            adapterPopularTvSeries as TvSeriesAdapter
        }

    override fun getTrendingTvSeriesAdapter(): TvSeriesAdapter =
        if (adapterTrendingTvSeries == null) {
            val adapter = TvSeriesAdapter(onTvSeriesClick, imageLoader)
            adapterTrendingTvSeries = adapter
            adapter
        } else {
            adapterTrendingTvSeries as TvSeriesAdapter
        }

    override fun getTopRatedTvSeriesAdapter(): TvSeriesAdapter =
        if (adapterTopRatedTvSeries == null) {
            val adapter = TvSeriesAdapter(onTvSeriesClick, imageLoader)
            adapterTopRatedTvSeries = adapter
            adapter
        } else {
            adapterTopRatedTvSeries as TvSeriesAdapter
        }
}