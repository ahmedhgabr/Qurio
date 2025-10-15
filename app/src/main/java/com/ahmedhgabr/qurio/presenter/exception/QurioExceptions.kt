package com.ahmedhgabr.qurio.presenter.exception

sealed class QurioExceptions(override val message: String? = null) : Exception(message) {
    class NetworkException(message: String?) : QurioExceptions(message)
    class ServerException(message: String?) : QurioExceptions(message)
    sealed class AuthenticationException(message: String?) : QurioExceptions(message)
    class TokenNotFound(message: String?) : AuthenticationException(message)
    class TokenEmpty(message: String?) : AuthenticationException(message)
    data class UnknownException(val error: String) : QurioExceptions()
}