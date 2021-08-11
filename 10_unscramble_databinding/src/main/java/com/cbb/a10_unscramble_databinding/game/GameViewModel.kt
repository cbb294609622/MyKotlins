package com.cbb.a10_unscramble_databinding.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private val _score = MutableLiveData(0)
    val score:LiveData<Int>
        get() = _score

    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount:LiveData<Int>
        get() = _currentWordCount

    private var _currentScrambledWord = MutableLiveData<String>()
    val currentScrambledWord:LiveData<String>
        get() = _currentScrambledWord

    //可变list集合
    private var wordsList: MutableList<String> = mutableListOf()

    //延时初始化
    private lateinit var currentWord: String

    init {
        Log.e("GameFragment", "GameViewModel created!")
        getNextWord()
    }

    private fun getNextWord() {
        //取出一个单词
        currentWord = allWordsList.random()
        //将单词变成数组
        var tempWord = currentWord.toCharArray()
        tempWord.shuffle()//打乱字符顺序
        //如果打乱的顺序和本身相同则接着打乱
        while (tempWord.toString().equals(currentWord,false)){
            tempWord.shuffle()
        }
        //判定单词是否已经使用过
        if (wordsList.contains(currentWord)){
            getNextWord()
        }else{
            _currentScrambledWord.value = String(tempWord)
            _currentWordCount.value = (_currentWordCount.value)?.inc()
            wordsList.add(currentWord)
        }
    }

    fun nextWord():Boolean{
        return if (_currentWordCount.value!! < MAX_NO_OF_WORDS){
            getNextWord()
            return true
        }else false
    }
    private fun increaseScore() {
        _score.value =(_score.value)?.plus(SCORE_INCREASE)
    }
    fun isUserWordCorrect(playerWord:String):Boolean{
        if (playerWord.equals(currentWord,true)){
            increaseScore()
            return true
        }
        return false
    }

    fun reinitializeData(){
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }


}