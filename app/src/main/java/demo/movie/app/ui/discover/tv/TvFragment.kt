package demo.movie.app.ui.discover.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import demo.movie.app.R
import demo.movie.app.model.dto.tv.TvPreviewDto

class TvFragment : Fragment(), TvContract.TvView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.discover_tv_fragment, container, false)
    }

    override fun setPopular(popularMovieList: List<TvPreviewDto>) {
        TODO("Not yet implemented")
    }

    override fun setTrending(trendingMovieList: List<TvPreviewDto>) {
        TODO("Not yet implemented")
    }

    override fun setTopRated(topRatedMovieList: List<TvPreviewDto>) {
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

    override fun showData() {
        TODO("Not yet implemented")
    }

    override fun showTvDetail(movie: TvPreviewDto) {
        TODO("Not yet implemented")
    }

}