package demo.movie.app.ui.discover

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import demo.movie.app.R

class DiscoverActivity :
    DiscoverContract.DiscoverView,
    AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.discover_activity)
    }
}