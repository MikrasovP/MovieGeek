package demo.movie.app.ui.recycler.adapters

import demo.movie.app.util.image.BaseImageLoader
import javax.inject.Inject

class AdapterProvider constructor()  {


    private var adapterRecommendedMovies: MovieAdapter? = null

    private var adapterPopularTvSeries: TvSeriesAdapter? = null
    private var adapterTrendingTvSeries: TvSeriesAdapter? = null
    private var adapterTopRatedTvSeries: TvSeriesAdapter? = null

    private var castAdapter: CastAdapter? = null


    /*override fun getRecommendedMoviesAdapter(): MovieAdapter =
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

    override fun getCastAdapter(): CastAdapter =
        if (castAdapter == null) {
            val adapter = CastAdapter(onCastMemberClick, imageLoader)
            castAdapter = adapter
            adapter
        } else {
            castAdapter as CastAdapter
        }*/

}