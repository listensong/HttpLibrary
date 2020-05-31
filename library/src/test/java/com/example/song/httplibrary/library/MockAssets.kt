package com.example.song.httplibrary.library

import java.io.File
import java.nio.charset.Charset

/**
 * @package com.example.song.httplibrary.library
 * @fileName MockAssets
 * @date on 5/31/2020 1:56 PM
 * @author Listensong
 * @desc
 * @email No
 */
object MockAssets {

    fun readFile(path: String): String {
        return file2String(File(path))
    }

    fun file2String(f: File, charset: Charset = Charsets.UTF_8): String {
        return f.readText(charset)
    }
}