package com.example.song.httplibrary.library

import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * @package com.example.song.httplibrary
 * @fileName LibraryService
 * @date on 5/31/2020 10:13 AM
 * @author Listensong
 * @desc
 * @email No
 */
internal interface TestLibraryService {
    //首页
    @GET("/")
    fun queryTestUrl(): CoroutineLifecycleCall<ResponseBody>
}