package com.example.song.httplibrary.library

/**
 * @package com.example.song.httplibrary.library
 * @fileName ILifecycleCall
 * @date on 5/30/2020 10:56 PM
 * @author Listensong
 * @desc
 * @email No
 */

interface CoroutineLifecycleCall<T> {
    fun cancel()
    fun enqueue(callback: CoroutineLifecycleCallback<T>)
    fun clone(): CoroutineLifecycleCall<T>
    fun isCanceled(): Boolean
    fun enableCancel(): Boolean
}