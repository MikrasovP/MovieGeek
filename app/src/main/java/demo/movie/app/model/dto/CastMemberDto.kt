package demo.movie.app.model.dto

import com.google.gson.annotations.SerializedName

data class CastMemberDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("character")
    val character: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("profile_path")
    val profile_path: String?
)