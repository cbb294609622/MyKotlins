package com.cbb.a06_affirmations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cbb.a06_affirmations.adapter.ItemAdapter
import com.cbb.a06_affirmations.data.DataSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myData = DataSource().loadAffirmation()

        recycler_view.adapter = ItemAdapter(this,myData)
        recycler_view.setHasFixedSize(true)

    }
}