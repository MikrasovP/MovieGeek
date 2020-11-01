package demo.movie.app.ui.detail.tv

import android.util.Log
import demo.movie.app.model.dto.tv.TvPreviewDto
import demo.movie.app.model.repo.tv.BaseTvRepo
import demo.movie.app.ui.mvp.PresenterBase
import demo.movie.app.util.rx.BaseSchedulerProvider
import javax.inject.Inject

class TvDetailPresenter @Inject constructor(
    var tvRepo: BaseTvRepo,
    var schedulerProvider: BaseSchedulerProvider,
) :
    TvDetailContract.Presenter,
    PresenterBase<TvDetailContract.View>() {

    companion object {
        private const val TAG = "MovieDetailPresenter"
    }

    override fun setTvPreviewAndUpdateDetails(tvPreview: TvPreviewDto) {

        tvRepo.getTvDetails(tvPreview.id)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe(
                {
                    view?.showFullData(it)
                },
                {
                    Log.e(TAG, "setMoviePreviewAndUpdateDetails: ${it.message}", it)
                })
    }


    override fun viewIsReady() {

    }

    override fun destroy() {

    }


}