@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package com.example.song.httplibrary.library

import okhttp3.Response

/**
 * @package com.example.song.httplibrary.library
 * @fileName HttpResult
 * @date on 5/30/2020 10:49 PM
 * @author Listensong
 * @desc
 * @email No
 */
data class NetworkError(
    val errorCode: Int,
    val errorMessage: String?,
    val exception: Exception
)

sealed class HttpResult<out T: Any> {
    class Okay<out T: Any> (
        val value: T,
        val response: Response
    ): HttpResult<T>() {
        override fun toString(): String {
            return "HttpResult.Okay{value=$value, response=$response}"
        }
    }

    class Error (
        val error: NetworkError
    ): HttpResult<Nothing>() {
        override fun toString(): String {
            return "HttpResult.Error{error=$error}"
        }
    }
}

inline fun <T: Any> HttpResult<T>.onFailure(
    action: (HttpResult.Error) -> Any
): HttpResult<T> {
    return if (this is HttpResult.Error) {
        action(this)
        this
    } else {
        this
    }
}

inline fun <T: Any> HttpResult<T>.onSuccess(
    action: (HttpResult.Okay<T>) -> Any
): HttpResult<T>? {
    if (this is HttpResult.Okay) {
        action(this)
    }
    return this
}

inline fun <T: Any> HttpResult<T>?.followDo(
    action: (HttpResult<T>?) -> Any
) : Any {
    return action(this)
}