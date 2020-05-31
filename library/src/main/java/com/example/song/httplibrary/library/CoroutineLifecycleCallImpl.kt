package com.example.song.httplibrary.library

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @package com.example.song.httplibrary.library
 * @fileName LifecycleCallImpl
 * @date on 5/30/2020 10:50 PM
 * @author Listensong
 * @desc
 * @email No
 */
class CoroutineLifecycleCallImpl<T>(
    private val callImpl: Call<T>,
    private val enableCancel: Boolean
) : CoroutineLifecycleCall<T> {

    override fun cancel() {
        callImpl.cancel()
    }

    override fun enqueue(callback: CoroutineLifecycleCallback<T>) {
        callImpl.enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                callback.onFail(0, t)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                callback.onSuccess(response.code(), response)
            }
        })
    }

    override fun clone(): CoroutineLifecycleCall<T> {
        return CoroutineLifecycleCallImpl<T>(callImpl.clone(), enableCancel)
    }

    override fun isCanceled(): Boolean {
        return callImpl.isCanceled
    }

    override fun enableCancel(): Boolean {
        return enableCancel
    }

}