package demo.movie.app.ui.discover

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import demo.movie.app.R
import demo.movie.app.ui.discover.movie.MovieFragment
import demo.movie.app.ui.discover.profile.ProfileFragment
import demo.movie.app.ui.discover.tv.TvFragment
import kotlinx.android.synthetic.main.discover_activity.*

class DiscoverActivity : AppCompatActivity() {

    private lateinit var movieFragment: MovieFragment
    private lateinit var tvFragment: TvFragment
    private lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.discover_activity)

        movieFragment = MovieFragment()
        tvFragment = TvFragment()
        profileFragment = ProfileFragment()

        showFragment(movieFragment)

        nav_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_movie -> showFragment(movieFragment)
                R.id.item_tv_series -> showFragment(tvFragment)
                R.id.item_profile -> showFragment(profileFragment)
                else -> false
            }
        }
    }

    private fun showFragment(fragment: Fragment) : Boolean {
        return supportFragmentManager.beginTransaction().run {
            replace(R.id.discover_placeholder, fragment)
            commit() > 0
        }
    }
}