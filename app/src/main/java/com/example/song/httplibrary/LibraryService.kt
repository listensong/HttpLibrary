package com.example.song.httplibrary

import com.example.song.httplibrary.library.CoroutineLifecycleCall
import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * @package com.example.song.httplibrary
 * @fileName LibraryService
 * @date on 5/31/2020 10:13 AM
 * @author Listensong
 * @desc TODO
 * @email No
 */
interface LibraryService {
    //首页
    @GET("/")
    fun queryBaidu(): CoroutineLifecycleCall<ResponseBody>
}