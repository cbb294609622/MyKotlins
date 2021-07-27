package com.cbb.mykotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.cbb.mykotlin.databinding.ActivityMainBinding
import com.cbb.mykotlin.db.UserDataBase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        UserDataBase.getInstance(this)
            .getStatusDao()
            .query()
            .observe(this, Observer {
                Log.e("chen", "it = $it " )
                if (it != true){
                    Navigation.findNavController(this,R.id.fragmentContainerView)
                        .navigate(R.id.nav_to_login)
                }
            })

    }
}