package demo.movie.app.ui.detail.tv

import android.content.Intent
import android.os.Bundle
import android.os.ParcelFormatException
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import demo.movie.app.R
import demo.movie.app.model.dto.CastMemberDto
import demo.movie.app.model.dto.tv.TvDetailDto
import demo.movie.app.model.dto.tv.TvPreviewDto
import demo.movie.app.ui.recycler.adapters.CastAdapter
import demo.movie.app.ui.recycler.adapters.TvSeriesAdapter
import demo.movie.app.util.DateConverter
import demo.movie.app.util.image.BaseImageLoader
import demo.movie.app.util.image.ImageSize
import kotlinx.android.synthetic.main.detail_activity.*
import java.util.*
import javax.inject.Inject

class TvDetailActivity : TvDetailContract.View, DaggerAppCompatActivity() {

    companion object {
        const val TV_PREVIEW_EXTRA_NAME = "tv_id"
        private const val TAG = "TvDetailActivity"
    }

    @Inject
    lateinit var presenter: TvDetailContract.Presenter

    @Inject
    lateinit var imageLoader: BaseImageLoader

    private lateinit var castAdapter: CastAdapter
    private lateinit var recommendationsAdapter: TvSeriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val tvPreview = intent.getParcelableExtra<TvPreviewDto>(TV_PREVIEW_EXTRA_NAME)
            ?: throw ParcelFormatException()

        presenter.attachView(this)
        initRecyclers()
        presenter.viewIsReady()
        presenter.setTvPreviewAndUpdateDetails(tvPreview)
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.detachView()
    }

    private fun initRecyclers() {

        setUpRecyclerViewsAdapter()

        detail_recommendations_rv.apply {
            adapter = recommendationsAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        detail_cast_rv.apply {
            adapter = castAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

    private fun setUpRecyclerViewsAdapter() {
        castAdapter = CastAdapter({ showCastMember(it) }, imageLoader)
        recommendationsAdapter = TvSeriesAdapter({ showTvSeriesDetails(it) }, imageLoader)
    }

    private fun showTvSeriesDetails(tvPreview: TvPreviewDto) {
        val intent = Intent(applicationContext, TvDetailActivity::class.java)

        intent.putExtra(TV_PREVIEW_EXTRA_NAME, tvPreview)
        startActivity(intent)
    }

    private fun showCastMember(castMemberDto: CastMemberDto) {
        Log.i(TAG, "showCastMember: method is not implemented")
    }

    override fun showPreviewData(tvPreviewDto: TvPreviewDto) {
        detail_title_tv.text = tvPreviewDto.title
        if (tvPreviewDto.posterPath != null) {
            imageLoader.loadImagePoster(
                detail_poster_iv,
                tvPreviewDto.posterPath,
                detail_poster_iv,
                ImageSize.W500
            )
        }

        val year = DateConverter
            .convertServerDateToCalendar(tvPreviewDto.releaseDate)
            .get(Calendar.YEAR)

        detail_year_tv.text = year.toString()
    }

    override fun showFullData(tvDetail: TvDetailDto) {
        detail_title_tv.text = tvDetail.title
        if (tvDetail.posterPath != null) {
            imageLoader.loadImagePoster(
                detail_poster_iv,
                tvDetail.posterPath,
                detail_poster_iv,
                ImageSize.W500
            )
        }

        val year = DateConverter
            .convertServerDateToCalendar(tvDetail.firstAirDate)
            .get(Calendar.YEAR)

        detail_year_tv.text = year.toString()

        detail_genre_tv.text = tvDetail.genres
            .joinToString(separator = ", ") { it.name }

        detail_overview_tv.text = tvDetail.overview

        castAdapter.updateItems(tvDetail.credits.cast)
        recommendationsAdapter.updateData(tvDetail.recommendations.results)
    }

}