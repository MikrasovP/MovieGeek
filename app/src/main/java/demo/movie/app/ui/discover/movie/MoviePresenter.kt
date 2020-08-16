package demo.movie.app.ui.discover.movie

import demo.movie.app.model.dto.MoviePreviewDto
import demo.movie.app.ui.mvp.PresenterBase

class MoviePresenter : PresenterBase<MovieContract.MovieView>(), MovieContract.MoviePresenter {

    override fun viewIsReady() {
        testRecyclers()
    }

    private fun testRecyclers(){
        val data: List<MoviePreviewDto> = listOf(
            MoviePreviewDto(1, true, 4.8, "Довод", "Tenet", "20 августа 2020", "https://upload.wikimedia.org/wikipedia/ru/5/56/Tenet_%28poster%29.jpg"),
            MoviePreviewDto(2, false, 3.7, "Начало", "Inception", "20 августа 2020", "https://upload.wikimedia.org/wikipedia/ru/b/bc/Poster_Inception_film_2010.jpg"),
            MoviePreviewDto(3, true, 2.6, "Однажды в... Голливуде", "Once upon a time in... Hollywood", "20 августа 2020", "https://kinohod.ru/o/72/ba/72ba9feb-2029-45e5-8e42-9d101df11160.jpg"),
            MoviePreviewDto(4, false, 1.5, "Криминальное чтиво", "Pulp fiction", "20 августа 2020", ""),
            MoviePreviewDto(5, true, 0.4, "Титаник", "Titanic", "20 августа 2020", "https://sun1-14.userapi.com/impf/c824201/v824201969/173424/ayWCFmi538s.jpg?size=200x0&quality=90&sign=b461a01af900c4374512c2b13455c25d&ava=1")
        )

        view?.showPopular(data)
        view?.showTrending(data)
        view?.showTopRated(data)
    }

    override fun destroy() {
        TODO("Not yet implemented")
    }

}