package demo.movie.app.util.image.path

import demo.movie.app.util.image.ImageSize

interface BaseImagePathMaker {
    fun getImageFullPath(
        imageRawPath: String,
        imageSize: ImageSize
    ): String
}