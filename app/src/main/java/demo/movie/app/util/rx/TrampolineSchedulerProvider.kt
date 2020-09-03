package demo.movie.app.util.rx

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class TrampolineSchedulerProvider : BaseSchedulerProvider {
    override fun io(): Scheduler =
        Schedulers.trampoline()

    override fun computation(): Scheduler =
        Schedulers.trampoline()

    override fun ui(): Scheduler =
        Schedulers.trampoline()
}