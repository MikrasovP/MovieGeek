package demo.movie.app.model.dto

import com.google.gson.annotations.SerializedName

data class CrewMemberDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("job")
    val job: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_path")
    val profilePath: String?
)