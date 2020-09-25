package demo.movie.app.util

import java.lang.IllegalArgumentException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Converts data from server (String) to Calendar
 */
class DateConverter {

    companion object {

        private const val PATTERN = "yyyy-MM-dd"

        fun convertServerDateToCalendar(serverDate: String): Calendar {
            val date = SimpleDateFormat(PATTERN, Locale.US).parse(serverDate)
                ?: throw IllegalArgumentException(serverDate)
            val calendar = Calendar.getInstance()
            calendar.time = date

            return calendar
        }


        fun convertCalendarToServerStringFormat(calendar: Calendar): String {
            return "${calendar.get(Calendar.YEAR)}-" +
                    "${calendar.get(Calendar.MONTH) + 1}-" +// month in range 0-11, but we need 1-12
                    "${calendar.get(Calendar.DAY_OF_MONTH)}"
        }
    }

}