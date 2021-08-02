package com.cbb.a06_affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cbb.a06_affirmations.R
import com.cbb.a06_affirmations.model.Affirmation

class ItemAdapter(private val mContext: Context, private val dataset: List<Affirmation>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val itemText:TextView = view.findViewById(R.id.item_title)
        val itemImage:ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var layout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var item = dataset[position]
        holder.itemText.text = mContext.resources.getString(item.stringResourceId)
        holder.itemImage.setImageResource(item.imageResourceId)
    }

    override fun getItemCount(): Int =dataset.size
}