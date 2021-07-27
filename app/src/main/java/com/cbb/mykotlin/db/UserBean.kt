package com.cbb.mykotlin.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "tb_user")
data class UserBean(
    @PrimaryKey
    val uid:Int = 0,
    @ColumnInfo
    val name:String,
    @ColumnInfo
    val sex:Int,
    @ColumnInfo
    val age:Int,
    @ColumnInfo
    val city:String
)

@Dao
interface UserDao{
    @Query("SELECT * FROM tb_user WHERE uid = 0")
    fun find():LiveData<UserBean>

    @Insert(entity = UserBean::class,onConflict = OnConflictStrategy.REPLACE)
    fun insert(user:UserBean)

    @Update
    fun update(user:UserBean)

    @Delete
    fun delete(user:UserBean)

}

@Entity(tableName = "tb_status")
data class Status(
    @PrimaryKey(autoGenerate = false)
    val id:Int = 0,
    @ColumnInfo
    val logged:Boolean
)

@Dao
interface StatusDao{
    @Query("SELECT logged FROM tb_status WHERE id = 0 ")
    fun query():LiveData<Boolean>


    @Insert
    fun insert(status:Status)
}