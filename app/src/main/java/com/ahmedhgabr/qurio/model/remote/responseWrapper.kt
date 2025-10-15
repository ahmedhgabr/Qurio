package com.ahmedhgabr.qurio.model.remote

import com.ahmedhgabr.qurio.model.remote.dto.BaseResponse
import com.ahmedhgabr.qurio.presenter.exception.QurioExceptions
import retrofit2.HttpException

suspend fun <T : BaseResponse> responseWrapper(
    block: suspend () -> T
): T {

    val successCode = 0
    val noResultsCode = 1
    val invalidParameterCode = 2
    val tokenNotFoundCode = 3
    val tokenEmptyCode = 4
    val rateLimitCode = 5

    try {
        val result = block()
        when (result.responseCode) {
            successCode -> return result
            noResultsCode -> throw QurioExceptions.ServerException("No results could be returned for the given query.")
            invalidParameterCode -> throw QurioExceptions.ServerException("Invalid parameter in the API request.")
            tokenNotFoundCode -> throw QurioExceptions.TokenNotFound("Session Token does not exist.")
            tokenEmptyCode -> throw QurioExceptions.TokenEmpty("Session Token has returned all possible questions for the specified query. Resetting the Token is necessary.")
            rateLimitCode -> throw QurioExceptions.ServerException("Too many requests have been made with the same token in a short amount of time.")
            else -> throw QurioExceptions.UnknownException("Unknown response code: ${result.responseCode}")
        }
    } catch (e: HttpException) {
        throw QurioExceptions.NetworkException(
            e.localizedMessage ?: "Please check your internet connection."
        )
    } catch (e: QurioExceptions) {

        throw e
    } catch (e: Exception) {
        throw QurioExceptions.UnknownException(e.localizedMessage ?: "An unknown error occurred")
    }
}