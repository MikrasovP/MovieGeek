package demo.movie.app.ui.detail.tv

import demo.movie.app.model.dto.tv.TvDetailDto
import demo.movie.app.model.dto.tv.TvPreviewDto
import demo.movie.app.ui.mvp.MvpPresenter
import demo.movie.app.ui.mvp.MvpView

interface TvDetailContract {
    interface View : MvpView {
        fun showPreviewData(tvPreviewDto: TvPreviewDto)

        fun showFullData(tvDetail: TvDetailDto)
    }

    interface Presenter : MvpPresenter<View> {
        fun setTvPreviewAndUpdateDetails(tvPreview: TvPreviewDto)
    }
}