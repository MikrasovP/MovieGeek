package demo.movie.app.ui.discover.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import demo.movie.app.R
import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.ui.discover.recycler.adapters.MovieAdapter
import demo.movie.app.util.image.BaseImageLoader
import kotlinx.android.synthetic.main.discover_movies_fragment.*
import javax.inject.Inject

class MovieFragment : DaggerFragment(), MovieContract.MovieView {

    @Inject
    lateinit var presenter: MoviePresenter

    @Inject
    lateinit var imageLoader: BaseImageLoader

    private lateinit var adapterPopularMovies: MovieAdapter

    private lateinit var adapterTrendingMovies: MovieAdapter

    private lateinit var adapterTopRatedMovies: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter.attachView(this)

        adapterPopularMovies = MovieAdapter({ showMovieDetail(it) }, imageLoader)

        adapterTrendingMovies = MovieAdapter({ showMovieDetail(it) }, imageLoader)

        adapterTopRatedMovies = MovieAdapter({ showMovieDetail(it) }, imageLoader)

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

        popular_movies_rv.apply {
            adapter = this@MovieFragment.adapterPopularMovies
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
        trending_movies_rv.apply {
            adapter = this@MovieFragment.adapterTrendingMovies
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
        top_movies_rv.apply {
            adapter = this@MovieFragment.adapterTopRatedMovies
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

    override fun setPopular(popularMovieList: List<MoviePreviewDto>) {
        adapterPopularMovies.updateData(popularMovieList)
    }

    override fun setTrending(trendingMovieList: List<MoviePreviewDto>) {
        adapterTrendingMovies.updateData(trendingMovieList)
    }

    override fun setTopRated(topRatedMovieList: List<MoviePreviewDto>) {
        adapterTopRatedMovies.updateData(topRatedMovieList)
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
        TODO("Navigate to movie info fragment")
    }

}