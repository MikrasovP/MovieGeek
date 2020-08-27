package demo.movie.app.util.image.path

import demo.movie.app.util.Constants
import demo.movie.app.util.image.ImageSize
import javax.inject.Inject

class ImagePathMaker @Inject constructor() : BaseImagePathMaker {
    override fun getImageFullPath(imageRawPath: String, imageSize: ImageSize): String =
        "${Constants.BASE_IMAGE_URL}${imageSize.string}$imageRawPath"

}