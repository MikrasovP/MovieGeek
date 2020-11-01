package demo.movie.app.model.dto.tv

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TvPreviewDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("name")
    val title: String,
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("first_air_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    val posterPath: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeDouble(voteAverage)
        parcel.writeString(title)
        parcel.writeString(originalName)
        parcel.writeString(releaseDate)
        parcel.writeString(posterPath)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TvPreviewDto> {
        override fun createFromParcel(parcel: Parcel): TvPreviewDto {
            return TvPreviewDto(parcel)
        }

        override fun newArray(size: Int): Array<TvPreviewDto?> {
            return arrayOfNulls(size)
        }
    }
}