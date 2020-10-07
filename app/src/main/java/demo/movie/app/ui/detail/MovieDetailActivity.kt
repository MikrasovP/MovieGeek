package demo.movie.app.ui.detail

import android.content.Intent
import android.os.Bundle
import android.os.ParcelFormatException
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import demo.movie.app.R
import demo.movie.app.model.dto.CastMemberDto
import demo.movie.app.model.dto.movie.MovieDetailDto
import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.ui.recycler.adapters.CastAdapter
import demo.movie.app.ui.recycler.adapters.MovieAdapter
import demo.movie.app.util.DateConverter
import demo.movie.app.util.image.BaseImageLoader
import demo.movie.app.util.image.ImageSize
import kotlinx.android.synthetic.main.detail_activity.*
import java.util.*
import javax.inject.Inject

class MovieDetailActivity : DaggerAppCompatActivity(), MovieDetailContract.View {

    companion object {
        const val MOVIE_PREVIEW_EXTRA_NAME = "movie_id"
        private const val TAG = "MovieDetailActivity"
    }

    @Inject
    lateinit var presenter: MovieDetailContract.Presenter

    @Inject
    lateinit var imageLoader: BaseImageLoader

    private lateinit var castAdapter: CastAdapter
    private lateinit var recommendationsAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val moviePreview = intent.getParcelableExtra<MoviePreviewDto>(MOVIE_PREVIEW_EXTRA_NAME)
            ?: throw ParcelFormatException()

        presenter.attachView(this)
        initRecyclers()
        presenter.viewIsReady()
        presenter.setMoviePreviewAndUpdateDetails(moviePreview)
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.detachView()
    }

    override fun showPreviewData(moviePreview: MoviePreviewDto) {
        detail_title_tv.text = moviePreview.title
        if (moviePreview.posterPath != null) {
            imageLoader.loadImagePoster(
                detail_poster_iv,
                moviePreview.posterPath,
                detail_poster_iv,
                ImageSize.W500
            )
        }

        val year = DateConverter
            .convertServerDateToCalendar(moviePreview.releaseDate)
            .get(Calendar.YEAR)

        detail_year_tv.text = year.toString()
    }

    override fun showFullData(movieDetail: MovieDetailDto) {
        detail_title_tv.text = movieDetail.title
        if (movieDetail.posterPath != null) {
            imageLoader.loadImagePoster(
                detail_poster_iv,
                movieDetail.posterPath,
                detail_poster_iv,
                ImageSize.W500
            )
        }

        val year = DateConverter
            .convertServerDateToCalendar(movieDetail.releaseDate)
            .get(Calendar.YEAR)

        detail_year_tv.text = year.toString()

        detail_genre_tv.text = movieDetail.genres
            .joinToString(separator = ", ") { it.name }

        detail_runtime_tv.text = getString(R.string.detail_runtime_pattern, movieDetail.runtime)

        detail_overview_tv.text = movieDetail.overview

        castAdapter.updateItems(movieDetail.credits.cast)
        recommendationsAdapter.updateData(movieDetail.recommendations.results)

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
        recommendationsAdapter = MovieAdapter({ showMovieDetails(it) }, imageLoader)
    }

    private fun showMovieDetails(moviePreview: MoviePreviewDto) {
        val intent = Intent(applicationContext, MovieDetailActivity::class.java)

        intent.putExtra(MOVIE_PREVIEW_EXTRA_NAME, moviePreview)
        startActivity(intent)
    }

    private fun showCastMember(castMemberDto: CastMemberDto) {
        Log.i(TAG, "showCastMember: method is not implemented")
    }

}