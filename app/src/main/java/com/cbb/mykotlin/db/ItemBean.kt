package com.cbb.mykotlin.db

import androidx.paging.DataSource
import androidx.room.*

@Entity(tableName = "tb_item")
data class ItemBean(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo
    val name:String,
    @ColumnInfo
    val color:Int
)

@Dao
interface ItemDao{
    @Insert
    fun insert(item:List<ItemBean>)

    @Query("SELECT * FROM tb_item")
    fun queryAll():DataSource.Factory<Int,ItemBean>
}