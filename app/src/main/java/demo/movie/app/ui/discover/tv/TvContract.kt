package demo.movie.app.ui.discover.tv

import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.model.dto.tv.TvPreviewDto
import demo.movie.app.ui.mvp.MvpPresenter
import demo.movie.app.ui.mvp.MvpView

interface TvContract {

    interface TvView : MvpView {

        fun setPopular(popularMovieList: List<TvPreviewDto>)

        fun setTrending(trendingMovieList: List<TvPreviewDto>)

        fun setTopRated(topRatedMovieList: List<TvPreviewDto>)

        fun showLoadError()

        fun showLoadingProgressBar()

        fun showReloadError()

        fun showData()

        fun showTvDetail(tvSeries: TvPreviewDto)

    }

    interface TvPresenter : MvpPresenter<TvView> {

        fun getAllData()

        fun refreshAllData()

    }

}