package com.ahmedhgabr.qurio.model.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesResponse(
    @SerialName("trivia_categories")
    val triviaCategories: List<CategoryDTO>,

    // TODO: remove responseCode from the API response
    override val responseCode: Int? = null // This is only added for error handling
) : BaseResponse

@Serializable
data class CategoryDTO(
    val id: Int,
    val name: String
)
