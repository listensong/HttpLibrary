package com.example.song.httplibrary.library

import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody

/**
 * @package com.example.song.httplibrary.library
 * @fileName AppTestUtils
 * @date on 5/31/2020 1:55 PM
 * @author Listensong
 * @desc
 * @email No
 */
object AppTestUtils {
    const val BASE_PATH = "../library/src/androidTest/assets"

    fun getMockResponseBody(filePath: String): ResponseBody {
        val mockJson: String = MockAssets.readFile(filePath)
        return mockJson.toResponseBody()
    }

    fun generateMockResponseBody(fileName: String): ResponseBody {
        val mockJson: String = readLocalJsonFile(fileName)
        return mockJson.toResponseBody()
    }

    fun readLocalJsonFile(fileName: String): String {
        return MockAssets.readFile("$BASE_PATH/$fileName")
    }
}