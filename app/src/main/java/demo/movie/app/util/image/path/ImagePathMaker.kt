package demo.movie.app.util.image.path

import demo.movie.app.util.Constants
import demo.movie.app.util.image.ImageSize
import javax.inject.Inject

/**
 * Util for forming image path to load image from TMDb
 *
 */
class ImagePathMaker @Inject constructor() : BaseImagePathMaker {

    /**
     * @param imageRawPath usually is got with other movie/tv data.
     * Example: "/ozPDfBmsrJDFF9ZhwQNxcGLXvzm.jpg"
     * @param imageSize points the size of the image
     */
    override fun getImageFullPath(imageRawPath: String, imageSize: ImageSize): String =
        "${Constants.BASE_IMAGE_URL}${imageSize.string}$imageRawPath"

}