package demo.movie.app.util.image

import android.view.View
import android.widget.ImageView

interface BaseImageLoader {

    fun loadImagePoster(
        viewWith: View,
        imageRawPath: String,
        viewInto: ImageView,
        imageSize: ImageSize
    )

}