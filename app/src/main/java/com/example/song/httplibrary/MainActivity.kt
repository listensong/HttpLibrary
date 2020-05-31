package com.example.song.httplibrary

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.song.httplibrary.library.awaitTimeout
import kotlinx.coroutines.GlobalScope

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        testLibraryCall()
    }

    private fun testLibraryCall() {
        Log.e("HelloWorld", "testLibraryCall. start " + Thread.currentThread())
        LibraryCallImpl.getInstance()
            .callTestApi(LibraryService::class.java)
            .queryBaidu()
            .awaitTimeout(GlobalScope, 1000)
            .onFailure {
                Log.e("HelloWorld", "testLibraryCall onFailure " + it)
                Log.e("HelloWorld", "testLibraryCall onFailure " + Thread.currentThread())
            }
            .onSuccess {
                Log.e("HelloWorld", "testLibraryCallY onSuccess " + it.value.string())
                Log.e("HelloWorld", "testLibraryCallY onSuccess " + Thread.currentThread())
            }
            .onComplete {
                Log.e("HelloWorld", "testLibraryCall onComplete " + Thread.currentThread())
            }
            .delayStart(1000)
    }

}