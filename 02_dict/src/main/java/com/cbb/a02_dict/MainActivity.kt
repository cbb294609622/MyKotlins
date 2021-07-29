package com.cbb.a02_dict

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun addDict(view: View) = imgSelect(Dice(6).roll())

    private fun imgSelect(rolls: Int) {

        val imageRes = when(rolls){
            1 -> R.mipmap.dice_1
            2 -> R.mipmap.dice_2
            3 -> R.mipmap.dice_3
            4 -> R.mipmap.dice_4
            5 -> R.mipmap.dice_5
            else -> R.mipmap.dice_6
        }
        imageView.setImageResource(imageRes)
        //显示说明文字
        imageView.contentDescription = rolls.toString()
    }


    /**
     * if
     */
    fun ifSelect(rolls: Int) {
        if (rolls == 4) {
            Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "You didn't win,try again!", Toast.LENGTH_SHORT).show()
        }
    }

    fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }


}