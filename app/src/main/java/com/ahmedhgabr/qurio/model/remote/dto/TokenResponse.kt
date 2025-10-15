package com.ahmedhgabr.qurio.model.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(
    @SerialName("response_code")
    override val responseCode: Int? = null,
    @SerialName("response_message")
    val responseMessage: String? = null,
    val token: String
) : BaseResponse