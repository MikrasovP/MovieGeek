package demo.movie.app.ui.discover

import android.os.Bundle
import android.view.MenuItem
import dagger.android.support.DaggerAppCompatActivity
import demo.movie.app.R
import demo.movie.app.ui.discover.movie.MovieFragment
import demo.movie.app.ui.discover.profile.ProfileFragment
import demo.movie.app.ui.discover.tv.TvFragment
import kotlinx.android.synthetic.main.discover_activity.*

class DiscoverActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.discover_activity)

        nav_view.setOnNavigationItemSelectedListener { onNavigationClick(it) }
        if(savedInstanceState==null)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MovieFragment())
                .commit()
    }

    private fun onNavigationClick(item: MenuItem): Boolean {
        val selectedFragment = when (item.itemId) {
            R.id.movie_fragment_item -> MovieFragment()
            R.id.tv_fragment_item -> TvFragment()
            R.id.profile_fragment_item -> ProfileFragment()
            else -> throw IllegalStateException()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, selectedFragment)
            .commit()

        return true
    }
}