package com.cbb.mykotlin.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.cbb.mykotlin.db.ItemBean
import com.cbb.mykotlin.db.UserDataBase

class ListWorker(private val context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {

        val list = mutableListOf<ItemBean>()
        for (i in 1..400){
            list.add(ItemBean(i,"haha$i",i%9))
        }
            UserDataBase.getInstance(context)
                .getItemDao()
                .insert(list)
        return Result.success()
    }
}