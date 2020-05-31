package com.example.song.httplibrary.library

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

/**
 * @package com.example.song.httplibrary.library
 * @fileName ErrorHandleCallAdapter
 * @date on 5/30/2020 10:48 PM
 * @author Listensong
 * @desc
 * @email No
 */
class CoroutineCallEventHandleCallAdapter<R> internal constructor(
    private val responseType: Type,
    private val enableCancel: Boolean
) : CallAdapter<R, CoroutineLifecycleCall<R>> {
    override fun adapt(call: Call<R>): CoroutineLifecycleCall<R> {
        return CoroutineLifecycleCallImpl(call, enableCancel)
    }

    override fun responseType(): Type {
        return responseType
    }
}