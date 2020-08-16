package demo.movie.app.ui.discover

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.android.support.DaggerAppCompatActivity
import demo.movie.app.R
import kotlinx.android.synthetic.main.discover_activity.*

class DiscoverActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.discover_activity)
        setupNavigation()
    }

    private fun setupNavigation(){
        val navHostFragment : NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        nav_view.setupWithNavController(navHostFragment.navController)
    }
}