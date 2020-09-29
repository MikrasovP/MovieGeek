package demo.movie.app.util

import org.junit.Before
import org.junit.Test
import java.util.*

class DateConverterTest {

    private companion object {
        const val PROPER_SERVER_DATE_1 = "2020-12-25"
        const val PROPER_YEAR_1 = 2020
        const val PROPER_MONTH_1 = 11
        const val PROPER_DAY_1 = 25

        const val PROPER_SERVER_DATE_2 = "2000-10-30"
        const val PROPER_YEAR_2 = 2000
        const val PROPER_MONTH_2 = 9
        const val PROPER_DAY_2 = 30

        const val PROPER_SERVER_DATE_3 = "1920-01-25"
        const val PROPER_YEAR_3 = 1920
        const val PROPER_MONTH_3 = 0
        const val PROPER_DAY_3 = 25

        val PROPER_CALENDAR_DATE_1: Calendar = Calendar.getInstance()
        val PROPER_CALENDAR_DATE_2: Calendar = Calendar.getInstance()
        val PROPER_CALENDAR_DATE_3: Calendar = Calendar.getInstance()

    }

    @Before
    fun setUp() {
        PROPER_CALENDAR_DATE_1.set(PROPER_YEAR_1, PROPER_MONTH_1, PROPER_DAY_1)
        PROPER_CALENDAR_DATE_2.set(PROPER_YEAR_2, PROPER_MONTH_2, PROPER_DAY_2)
        PROPER_CALENDAR_DATE_3.set(PROPER_YEAR_3, PROPER_MONTH_3, PROPER_DAY_3)
    }

    @Test
    fun testConvertServerDateToCalendar() {
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

    @Test
    fun testConvertCalendarToServerDate() {
        var serverDate = DateConverter.convertCalendarToServerStringFormat(PROPER_CALENDAR_DATE_1)
        assert(serverDate == PROPER_SERVER_DATE_1)

        serverDate = DateConverter.convertCalendarToServerStringFormat(PROPER_CALENDAR_DATE_2)
        assert(serverDate == PROPER_SERVER_DATE_2)

        serverDate = DateConverter.convertCalendarToServerStringFormat(PROPER_CALENDAR_DATE_3)
        assert(serverDate == PROPER_SERVER_DATE_3)
    }
}