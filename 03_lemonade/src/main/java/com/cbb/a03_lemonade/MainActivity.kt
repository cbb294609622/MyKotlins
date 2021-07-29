package com.cbb.a03_lemonade

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var type :String = "SELECT"
    private var lemonSize:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lemonSize = randInt()
        textView2.text = "$lemonSize"
        tvText(1)
        ivRes(1)
    }

    fun ivClick(view: View) {
        when(type){
            "SELECT" ->
                if (lemonSize == 1){
                    lemonSize = randInt()
                    tvText(2)
                    ivRes(2)
                    type = "SQUEEZE"
                }else{
                    lemonSize -= 1
                }
            "SQUEEZE" ->
                if (lemonSize == 1){
                    lemonSize = randInt()
                    tvText(3)
                    ivRes(3)
                    type = "DRINK"
                }else{
                    lemonSize -= 1
                }
            "DRINK" ->
                if (lemonSize == 1){
                    lemonSize = randInt()
                    tvText(4)
                    ivRes(4)
                    type = "RESTART"
                }else{
                    lemonSize -= 1
                }
            "RESTART" ->
                if (lemonSize == 1){
                    lemonSize = randInt()
                    tvText(1)
                    ivRes(1)
                    type = "SELECT"
                }else{
                    lemonSize -= 1
                }
        }
        textView2.text = "$lemonSize"
    }


    fun tvText(index: Int) {
        var desStr = when (index) {
            1 -> "点击选择柠檬!"
            2 -> "点击将柠檬榨汁!"
            3 -> "点击饮用柠檬汁!"
            else -> "点击以重新开始!"
        }
        textView.text = desStr
    }

    fun ivRes(index:Int){
        var ivR = when(index){
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            else -> R.drawable.lemon_restart
        }
        imageView.setImageResource(ivR)
    }


    fun randInt():Int =(4..8).random()
}