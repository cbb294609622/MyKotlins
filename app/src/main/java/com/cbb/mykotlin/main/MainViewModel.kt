package com.cbb.mykotlin.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.DiffUtil
import com.cbb.mykotlin.adapter.MyAdapter
import com.cbb.mykotlin.db.ItemBean
import com.cbb.mykotlin.db.UserDataBase

class MainViewModel(application: Application) : AndroidViewModel(application) {


    private val diffCallBack = object : DiffUtil.ItemCallback<ItemBean>() {
        override fun areItemsTheSame(oldItem: ItemBean, newItem: ItemBean): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemBean, newItem: ItemBean): Boolean {
            return oldItem.name == newItem.name
        }

    }
    val mAdapter = MyAdapter(diffCallBack)

    val liveList:LiveData<PagedList<ItemBean>>
    init {
        var itemDao = UserDataBase.getInstance(getApplication())
            .getItemDao()
        liveList = LivePagedListBuilder<Int,ItemBean>(
            itemDao.queryAll(),
            PagedList.Config.Builder()
                .setInitialLoadSizeHint(100)//初始加载数量   必须是页码数的整数倍
                .setPageSize(50)//页码数
                .setEnablePlaceholders(false)//是否占位
                .setPrefetchDistance(10) //剩余最后10条时，开始加载下一页
                .build()
        ).build()
    }

}