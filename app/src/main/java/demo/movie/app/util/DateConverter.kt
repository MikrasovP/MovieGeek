package demo.movie.app.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Converts data from server (String) to ...
 */
class DateConverter {

    companion object {
        fun convertServerData(serverData: String) {
            val date = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(serverData)
        }
    }

}