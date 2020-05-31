package com.example.song.httplibrary.library

import retrofit2.Response

/**
 * @package com.example.song.httplibrary.library
 * @fileName ILifecycleCallback
 * @date on 5/30/2020 10:49 PM
 * @author Listensong
 * @desc
 * @email No
 */
interface CoroutineLifecycleCallback<T> {
    fun onSuccess(statusCode: Int, response: Response<T>)
    fun onFail(statusCode: Int, throwable: Throwable)
    fun onFinish()
}