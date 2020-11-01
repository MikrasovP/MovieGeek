package demo.movie.app.model.dto.movie

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MoviePreviewDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("adult")
    val isAdult: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("title")
    val title: String,
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    val posterPath: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readDouble(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeByte(if (isAdult) 1 else 0)
        parcel.writeDouble(voteAverage)
        parcel.writeString(title)
        parcel.writeString(originalName)
        parcel.writeString(releaseDate)
        parcel.writeString(posterPath)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MoviePreviewDto> {
        override fun createFromParcel(parcel: Parcel): MoviePreviewDto {
            return MoviePreviewDto(parcel)
        }

        override fun newArray(size: Int): Array<MoviePreviewDto?> {
            return arrayOfNulls(size)
        }
    }

}