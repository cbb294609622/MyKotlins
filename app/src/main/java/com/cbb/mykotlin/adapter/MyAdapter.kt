package com.cbb.mykotlin.adapter

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cbb.mykotlin.databinding.ItemRvBinding
import com.cbb.mykotlin.db.ItemBean

class MyAdapter(diff:DiffUtil.ItemCallback<ItemBean>) :PagedListAdapter<ItemBean,
        MyAdapter.ListViewHolder>(diff){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var binding = ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ListViewHolder(private val binding:ItemRvBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item:ItemBean?){
            binding.bean = item
            binding.listener = View.OnClickListener {
                Log.e("chen", "点击了 item $item")
            }
        }
    }
}