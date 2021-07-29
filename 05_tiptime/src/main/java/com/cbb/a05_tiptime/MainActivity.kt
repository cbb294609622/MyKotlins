package com.cbb.a05_tiptime

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculate.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip(){
        val cost = editText.text.toString().toDoubleOrNull()
        if (cost == null){
            Toast.makeText(this, "please input number", Toast.LENGTH_SHORT).show()
            return
        }
        val tipPercentage = when(tip_options.checkedRadioButtonId){
            R.id.rbOne -> 0.20
            R.id.rbTwo -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        if (switch1.isChecked){
            tip = ceil(tip)
        }
        tip_result.text = "Tip Amount:%.2f".format(tip)
    }

}