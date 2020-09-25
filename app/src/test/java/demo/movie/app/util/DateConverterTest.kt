package demo.movie.app.util

import org.junit.Test
import java.util.*

class DateConverterTest {

    private companion object {
        const val PROPER_SERVER_DATE_1 = "2020-12-25"
        const val PROPER_YEAR_1 = 2020
        const val PROPER_MONTH_1 = 12
        const val PROPER_DAY_1 = 25

        const val PROPER_SERVER_DATE_2 = "2000-10-30"
        const val PROPER_YEAR_2 = 2000
        const val PROPER_MONTH_2 = 10
        const val PROPER_DAY_2 = 30

        const val PROPER_SERVER_DATE_3 = "1920-12-25"
        const val PROPER_YEAR_3 = 1920
        const val PROPER_MONTH_3 = 12
        const val PROPER_DAY_3 = 25
    }

    @Test
    fun test_convertServerDateToCalendar() {
        var calendar = DateConverter.convertServerDateToCalendar(PROPER_SERVER_DATE_1)

        assert(calendar.get(Calendar.YEAR) == PROPER_YEAR_1)
        assert(calendar.get(Calendar.MONTH) == PROPER_MONTH_1)
        assert(calendar.get(Calendar.DAY_OF_MONTH) == PROPER_DAY_1)

        calendar = DateConverter.convertServerDateToCalendar(PROPER_SERVER_DATE_2)

        assert(calendar.get(Calendar.YEAR) == PROPER_YEAR_2)
        assert(calendar.get(Calendar.MONTH) == PROPER_MONTH_2)
        assert(calendar.get(Calendar.DAY_OF_MONTH) == PROPER_DAY_2)

        calendar = DateConverter.convertServerDateToCalendar(PROPER_SERVER_DATE_3)

        assert(calendar.get(Calendar.YEAR) == PROPER_YEAR_3)
        assert(calendar.get(Calendar.MONTH) == PROPER_MONTH_3)
        assert(calendar.get(Calendar.DAY_OF_MONTH) == PROPER_DAY_3)
    }
}