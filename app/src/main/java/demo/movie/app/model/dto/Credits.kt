package demo.movie.app.model.dto

import com.google.gson.annotations.SerializedName

data class Credits (
    @SerializedName("id")
    val id: Int,
    @SerializedName("cast")
    val cast: List<CastMemberDto>,
    @SerializedName("crew")
    val crew: List<CrewMemberDto>
)