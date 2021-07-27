package com.cbb.mykotlin.base

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.cbb.mykotlin.worker.ListWorker

class BaseApp :Application() {

    private val worker = OneTimeWorkRequest.Builder(ListWorker::class.java).build()


    override fun onCreate() {
        super.onCreate()
        WorkManager.getInstance(this).enqueue(worker)
    }
}