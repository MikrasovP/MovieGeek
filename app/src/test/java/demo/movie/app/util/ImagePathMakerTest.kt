package demo.movie.app.util

import demo.movie.app.util.image.ImageSize
import demo.movie.app.util.image.path.ImagePathMaker
import org.junit.Assert.assertEquals
import org.junit.Test

class ImagePathMakerTest {

    companion object {
        private const val PROPER_IMAGE_RAW_PATH_1 = "/ozPDfBmsrJDFF9ZhwQNxcGLXvzm.jpg"
        private val PROPER_IMAGE_SIZE_1 = ImageSize.ORIGINAL
        private const val EXPECTED_IMAGE_FULL_PATH_1 = "https://image.tmdb.org/t/p/original/ozPDfBmsrJDFF9ZhwQNxcGLXvzm.jpg"

        private const val PROPER_IMAGE_RAW_PATH_2 = "/ozPDfBmsrJDFF9ZhwQNxcGLXvzm.jpg"
        private val PROPER_IMAGE_SIZE_2 = ImageSize.W500
        private const val EXPECTED_IMAGE_FULL_PATH_2 = "https://image.tmdb.org/t/p/w500/ozPDfBmsrJDFF9ZhwQNxcGLXvzm.jpg"
    }

    private val imagePathMaker: ImagePathMaker = ImagePathMaker()

    @Test
    fun testMakeFullPath_Proper(){
        assertEquals(
            EXPECTED_IMAGE_FULL_PATH_1,
            imagePathMaker.getImageFullPath(PROPER_IMAGE_RAW_PATH_1, PROPER_IMAGE_SIZE_1)
        )
        assertEquals(
            EXPECTED_IMAGE_FULL_PATH_2,
            imagePathMaker.getImageFullPath(PROPER_IMAGE_RAW_PATH_2, PROPER_IMAGE_SIZE_2)
        )
    }
}