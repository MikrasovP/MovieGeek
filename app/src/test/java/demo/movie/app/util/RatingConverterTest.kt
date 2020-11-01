package demo.movie.app.util

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.abs

class RatingConverterTest {

    companion object {
        private const val PROPER_SERVER_FORMAT_VALUE_01 = 0.1
        private const val EXPECTED_PROPER_SERVER_FORMAT_VALUE_01 = 1
        private const val PROPER_SERVER_FORMAT_VALUE_05 = 0.5
        private const val EXPECTED_PROPER_SERVER_FORMAT_VALUE_05 = 5
        private const val PROPER_SERVER_FORMAT_VALUE_100 = 10.0
        private const val EXPECTED_PROPER_SERVER_FORMAT_VALUE_100 = 100

        private const val IMPROPER_SERVER_FORMAT_VALUE_MINUS_01 = -0.1
        private const val IMPROPER_SERVER_FORMAT_VALUE_110 = 11.0

        private const val PROPER_LOCAL_FORMAT_VALUE_1 = 1
        private const val EXPECTED_PROPER_LOCAL_FORMAT_VALUE_1 = 0.1
        private const val PROPER_LOCAL_FORMAT_VALUE_5 = 5
        private const val EXPECTED_PROPER_LOCAL_FORMAT_VALUE_5 = 0.5
        private const val PROPER_LOCAL_FORMAT_VALUE_50 = 50
        private const val EXPECTED_PROPER_LOCAL_FORMAT_VALUE_50 = 5.0
        private const val PROPER_LOCAL_FORMAT_VALUE_100 = 100
        private const val EXPECTED_PROPER_LOCAL_FORMAT_VALUE_100 = 10.0

        private const val IMPROPER_LOCAL_FORMAT_VALUE_110 = 110
        private const val IMPROPER_LOCAL_FORMAT_VALUE_MINUS_1 = -1

        private const val DOUBLE_COMPARISION_DELTA = 0.00001
    }

    @Test
    fun testFromServerToLocal_ProperData(){
        assertEquals(
            EXPECTED_PROPER_SERVER_FORMAT_VALUE_01,
            RatingConverter.convertFromServerFormatToLocal(PROPER_SERVER_FORMAT_VALUE_01)
        )

        assertEquals(
            EXPECTED_PROPER_SERVER_FORMAT_VALUE_05,
            RatingConverter.convertFromServerFormatToLocal(PROPER_SERVER_FORMAT_VALUE_05)
        )

        assertEquals(
            EXPECTED_PROPER_SERVER_FORMAT_VALUE_100,
            RatingConverter.convertFromServerFormatToLocal(PROPER_SERVER_FORMAT_VALUE_100)
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun testFromServerToLocal_ImproperData_1(){
        RatingConverter.convertFromServerFormatToLocal(IMPROPER_SERVER_FORMAT_VALUE_MINUS_01)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testFormServerToLocal_ImproperData_2(){
        RatingConverter.convertFromServerFormatToLocal(IMPROPER_SERVER_FORMAT_VALUE_110)
    }

    @Test
    fun testFromLocalToServer_ProperData(){
        assert(assertEqualsDouble(
            RatingConverter.convertFromLocalFormatToServer(PROPER_LOCAL_FORMAT_VALUE_1),
            EXPECTED_PROPER_LOCAL_FORMAT_VALUE_1
        ))

        assert(assertEqualsDouble(
            RatingConverter.convertFromLocalFormatToServer(PROPER_LOCAL_FORMAT_VALUE_5),
            EXPECTED_PROPER_LOCAL_FORMAT_VALUE_5
        ))

        assert(assertEqualsDouble(
            RatingConverter.convertFromLocalFormatToServer(PROPER_LOCAL_FORMAT_VALUE_50),
            EXPECTED_PROPER_LOCAL_FORMAT_VALUE_50
        ))

        assert(assertEqualsDouble(
            RatingConverter.convertFromLocalFormatToServer(PROPER_LOCAL_FORMAT_VALUE_100),
            EXPECTED_PROPER_LOCAL_FORMAT_VALUE_100
        ))
    }

    @Test(expected = IllegalArgumentException::class)
    fun testFromLocalToServer_ImproperData_1(){
        RatingConverter.convertFromLocalFormatToServer(IMPROPER_LOCAL_FORMAT_VALUE_MINUS_1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testFromLocalToServer_ImproperData_2(){
        RatingConverter.convertFromLocalFormatToServer(IMPROPER_LOCAL_FORMAT_VALUE_110)
    }

    private fun assertEqualsDouble(first: Double, second: Double) : Boolean =
        abs(first - second) < DOUBLE_COMPARISION_DELTA

}