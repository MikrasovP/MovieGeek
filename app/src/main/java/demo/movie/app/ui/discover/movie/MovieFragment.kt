package demo.movie.app.ui.discover.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import demo.movie.app.R
import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.ui.discover.recycler.adapters.BaseAdapterProvider
import demo.movie.app.ui.discover.recycler.adapters.MovieAdapter
import demo.movie.app.util.image.BaseImageLoader
import kotlinx.android.synthetic.main.discover_movies_fragment.*
import javax.inject.Inject

class MovieFragment : DaggerFragment(), MovieContract.MovieView {

    companion object {
        private const val TAG = "MovieFragment"
    }

    @Inject
    lateinit var presenter: MoviePresenter

    @Inject
    lateinit var adapterProvider: BaseAdapterProvider

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        presenter.attachView(this)

        return inflater.inflate(R.layout.discover_movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = true
        initRecyclers()

        presenter.viewIsReady()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter.detachView()
    }

    private fun initRecyclers() {

        adapterProvider.onMovieClick = { showMovieDetail(it) }

        popular_movies_rv.apply {
            adapter = adapterProvider.getPopularMoviesAdapter()
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
        trending_movies_rv.apply {
            adapter = adapterProvider.getTrendingMoviesAdapter()
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
        top_movies_rv.apply {
            adapter = adapterProvider.getTopRatedMoviesAdapter()
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

    override fun setPopular(popularMovieList: List<MoviePreviewDto>) {
        adapterProvider.getPopularMoviesAdapter().updateData(popularMovieList)
    }

    override fun setTrending(trendingMovieList: List<MoviePreviewDto>) {
        adapterProvider.getTrendingMoviesAdapter().updateData(trendingMovieList)
    }

    override fun setTopRated(topRatedMovieList: List<MoviePreviewDto>) {
        adapterProvider.getTopRatedMoviesAdapter().updateData(topRatedMovieList)
    }

    override fun showLoadError() {
        movies_recyclers_sv.visibility = View.INVISIBLE
        load_spinner_pb.visibility = View.INVISIBLE
        load_error_tv.visibility = View.VISIBLE
    }

    override fun showLoadingProgressBar() {
        movies_recyclers_sv.visibility = View.INVISIBLE
        load_spinner_pb.visibility = View.VISIBLE
        load_error_tv.visibility = View.INVISIBLE
    }

    override fun showReloadError() {
        TODO("Not yet implemented")
    }

    override fun showData() {
        movies_recyclers_sv.visibility = View.VISIBLE
        load_spinner_pb.visibility = View.INVISIBLE
        load_error_tv.visibility = View.INVISIBLE
    }

    override fun showMovieDetail(movie: MoviePreviewDto) {
        Log.d(TAG, "showMovieDetail: $movie")
    }

}