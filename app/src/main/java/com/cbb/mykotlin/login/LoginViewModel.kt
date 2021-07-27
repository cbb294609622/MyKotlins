package com.cbb.mykotlin.login

import android.app.Application
import android.os.SystemClock
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.cbb.mykotlin.db.Status
import com.cbb.mykotlin.db.UserBean
import com.cbb.mykotlin.db.UserDataBase
import kotlin.concurrent.thread

class LoginViewModel(application: Application):AndroidViewModel(application) {
    val uname = ObservableField<String>()
    val upwd = ObservableField<String>()

    val loginOk = MutableLiveData<Boolean>()

    fun login(){
        Toast.makeText(getApplication(), "点击了按钮", Toast.LENGTH_SHORT).show()

        val user = UserBean(0,"张三",1,22,"北京")

        thread {
            UserDataBase.getInstance(getApplication())
                .getUserDao()
                .insert(user)
            UserDataBase.getInstance(getApplication())
                .getStatusDao()
                .insert(Status(logged = true))
        }
        SystemClock.sleep(500)
        loginOk.value = true

    }

}