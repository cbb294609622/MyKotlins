package com.cbb.a07_list.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cbb.a07_list.R

class TestActivity : AppCompatActivity() {
    companion object {
        const val TAG = "TestActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Log.e(TAG, "onCreate: ")
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart: ")
    }
}