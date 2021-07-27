package com.cbb.mykotlin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserBean::class,Status::class,ItemBean::class],version = 1,exportSchema = false)
abstract class UserDataBase : RoomDatabase(){
    abstract fun getUserDao():UserDao
    abstract fun getStatusDao():StatusDao
    abstract fun getItemDao():ItemDao

    companion object{
        private var instance:UserDataBase?=null
        fun getInstance(ctx : Context):UserDataBase{
            return instance?:Room.databaseBuilder(
                ctx,UserDataBase::class.java,
                "user_db").build()
        }
    }

}