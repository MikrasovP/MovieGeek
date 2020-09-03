package demo.movie.app.util.rx

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SchedulerProvider @Inject constructor(): BaseSchedulerProvider {

    override fun io(): Scheduler =
        Schedulers.io()

    override fun computation(): Scheduler =
        Schedulers.computation()

    override fun ui(): Scheduler =
        AndroidSchedulers.mainThread()

}