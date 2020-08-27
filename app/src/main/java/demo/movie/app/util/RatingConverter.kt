package demo.movie.app.util

/**
 * Converts between
 *      server format rating data and CircleRatingView (local) format
 */
class RatingConverter {
    companion object {

        private const val COEFFICIENT = 10
        private const val EPSILON = 0.00001
        private const val MIN_SERVER_VALUE = 0.0
        private const val MAX_SERVER_VALUE = 10.0
        private const val MIN_LOCAL_VALUE = 0
        private const val MAX_LOCAL_VALUE = 100

        /**
         * @throws IllegalArgumentException - argument must fits to server format range
         * @param value - server format data (0.0-10.0)
         * @return CircleRatingView format (int, 0-100)
         */
        fun convertFromServerFormatToLocal(value: Double) : Int {

            if(value < (MIN_SERVER_VALUE - EPSILON) ||
                value > (MAX_SERVER_VALUE + EPSILON))
                throw IllegalArgumentException("value: $value")

            return (value * COEFFICIENT).toInt()
        }

        /**
        * @throws IllegalArgumentException - argument must fits to local format range
        * @param value - CircleRatingView format (int, 0-100)
        * @return server format data (0.0-10.0)
        */
        fun convertFromLocalFormatToServer(value: Int) : Double {

            if(value < MIN_LOCAL_VALUE || value > MAX_LOCAL_VALUE)
                throw IllegalArgumentException("value: $value")

            return value.toDouble() / COEFFICIENT
        }


    }
}