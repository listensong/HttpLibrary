package com.example.song.httplibrary.library

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.Proxy
import java.util.concurrent.TimeUnit

/**
 * @package com.example.song.httplibrary
 * @fileName LibraryCallImpl
 * @date on 5/31/2020 10:16 AM
 * @author Listensong
 * @desc
 * @email No
 */
internal class TestLibraryCallImpl {

    private val libraryCallUrl = "https://www.HelloWorld.com"

    private val okHttpClient by lazy {
        OkHttpClient
            .Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .proxy(Proxy.NO_PROXY)
            .build()
    }

    fun <T> callTestApi(clazz: Class<T> ) : T {
        return callLibraryTestRetrofit().create(clazz)
    }

    private fun callLibraryTestRetrofit() : Retrofit {
        return Retrofit
            .Builder()
            .client(
                okHttpClient.newBuilder().build()
            )
            .baseUrl(libraryCallUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineLifecycleCallAdapterFactory())
            .build()
    }

    companion object {
        @JvmStatic
        fun getInstance(): TestLibraryCallImpl = Holder.INSTANCE
    }

    private object Holder {
        val INSTANCE = TestLibraryCallImpl()
    }
}