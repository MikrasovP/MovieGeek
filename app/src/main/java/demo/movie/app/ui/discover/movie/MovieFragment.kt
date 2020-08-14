package demo.movie.app.ui.discover.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import demo.movie.app.R
import demo.movie.app.model.dto.MoviePreviewDto

class MovieFragment : Fragment(), MovieContract.MovieView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.discover_movies_fragment, container, false)
    }

    override fun showPopular(popularMovieList: List<MoviePreviewDto>) {
        TODO("Not yet implemented")
    }

    override fun showTrending(trendingMovieList: List<MoviePreviewDto>) {
        TODO("Not yet implemented")
    }

    override fun showTopRated(topRatedMovieList: List<MoviePreviewDto>) {
        TODO("Not yet implemented")
    }

    override fun showLoadError() {
        TODO("Not yet implemented")
    }

    override fun showLoadingProgressBar() {
        TODO("Not yet implemented")
    }

    override fun showReloadError() {
        TODO("Not yet implemented")
    }

}