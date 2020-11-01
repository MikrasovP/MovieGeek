package demo.movie.app.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Converts data from server (String) to Calendar
 */
class DateConverter {

    companion object {

        private const val PATTERN = "yyyy-MM-dd"


        /**
         * @param serverDate string that matches server pattern
         */
        fun convertServerDateToCalendar(serverDate: String): Calendar {
            val date = SimpleDateFormat(PATTERN, Locale.US).parse(serverDate)
                ?: throw IllegalArgumentException(serverDate)
            val calendar = Calendar.getInstance()
            calendar.time = date

            return calendar
        }


        fun convertCalendarToServerStringFormat(calendar: Calendar): String {
            val dateFormat = SimpleDateFormat(PATTERN, Locale.US)
            val date = calendar.time

            return dateFormat.format(date)
        }
    }

}