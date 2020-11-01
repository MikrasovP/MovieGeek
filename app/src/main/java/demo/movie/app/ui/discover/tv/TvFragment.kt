package demo.movie.app.ui.discover.tv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import demo.movie.app.R
import demo.movie.app.model.dto.tv.TvPreviewDto
import demo.movie.app.ui.detail.movie.MovieDetailActivity
import demo.movie.app.ui.detail.tv.TvDetailActivity
import demo.movie.app.ui.recycler.adapters.TvSeriesAdapter
import demo.movie.app.util.image.ImageLoader
import kotlinx.android.synthetic.main.discover_tv_fragment.*
import javax.inject.Inject

class TvFragment : DaggerFragment(), TvContract.TvView {

    companion object {
        private const val TAG = "TvFragment"
    }

    @Inject
    lateinit var presenter: TvContract.TvPresenter

    @Inject
    lateinit var imageLoader: ImageLoader

    private lateinit var adapterPopularTvSeries: TvSeriesAdapter
    private lateinit var adapterTrendingTvSeries: TvSeriesAdapter
    private lateinit var adapterTopRatedTvSeries: TvSeriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        presenter.attachView(this)

        return layoutInflater.inflate(R.layout.discover_tv_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclers()

        presenter.viewIsReady()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter.detachView()
    }

    private fun initRecyclers() {

        setUpRecyclerViewsAdapters()

        rv_popular_tv_series.apply {
            adapter = adapterPopularTvSeries
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        rv_trending_tv_series.apply {
            adapter = adapterTrendingTvSeries
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        rv_top_rated_tv_series.apply {
            adapter = adapterTopRatedTvSeries
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

    }

    private fun setUpRecyclerViewsAdapters() {
        adapterPopularTvSeries = TvSeriesAdapter({ showTvDetail(it) }, imageLoader)
        adapterTrendingTvSeries = TvSeriesAdapter({ showTvDetail(it) }, imageLoader)
        adapterTopRatedTvSeries = TvSeriesAdapter({ showTvDetail(it) }, imageLoader)
    }

    override fun setPopular(popularMovieList: List<TvPreviewDto>) =
        adapterPopularTvSeries.updateData(popularMovieList)

    override fun setTrending(trendingMovieList: List<TvPreviewDto>) {
        adapterTrendingTvSeries.updateData(trendingMovieList)
    }

    override fun setTopRated(topRatedMovieList: List<TvPreviewDto>) {
        adapterTopRatedTvSeries.updateData(topRatedMovieList)
    }

    override fun showLoadError() {
        tv_recyclers_sv.visibility = View.INVISIBLE
        tv_series_load_error_tv.visibility = View.VISIBLE
        tv_series_load_spinner_pb.visibility = View.INVISIBLE
    }

    override fun showLoadingProgressBar() {
        tv_recyclers_sv.visibility = View.INVISIBLE
        tv_series_load_error_tv.visibility = View.INVISIBLE
        tv_series_load_spinner_pb.visibility = View.VISIBLE
    }

    override fun showReloadError() {
        TODO("Not yet implemented")
    }

    override fun showData() {
        tv_recyclers_sv.visibility = View.VISIBLE
        tv_series_load_error_tv.visibility = View.INVISIBLE
        tv_series_load_spinner_pb.visibility = View.INVISIBLE
    }

    override fun showTvDetail(tvSeries: TvPreviewDto) {
        Log.d(TAG, "showTvDetail: $tvSeries")
        val intent = Intent(requireActivity().applicationContext, TvDetailActivity::class.java)

        intent.putExtra(MovieDetailActivity.MOVIE_PREVIEW_EXTRA_NAME, tvSeries)
        requireActivity().startActivity(intent)
    }

}