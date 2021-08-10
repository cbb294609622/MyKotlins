package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private var _score = 0
    val score:Int
        get() = _score

    private var _currentWordCount = 0
    val currentWordCount:Int
        get() = _currentWordCount

    private lateinit var _currentScrambledWord:String
    val currentScrambledWord: String
        get() = _currentScrambledWord

    //可变list集合
    private var wordsList: MutableList<String> = mutableListOf()

    //延时初始化
    private lateinit var currentWord: String

    init {
        Log.e("GameFragment", "GameViewModel created!")
        getNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("GameFragment", "GameViewModel destoryed!")
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
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordsList.add(currentWord)
        }
    }

    fun nextWord():Boolean{
        return if (_currentWordCount < MAX_NO_OF_WORDS){
            getNextWord()
            return true
        }else false
    }
    private fun increaseScore() {
        _score += SCORE_INCREASE
    }
    fun isUserWordCorrect(playerWord:String):Boolean{
        if (playerWord.equals(currentWord,true)){
            increaseScore()
            return true
        }
        return false
    }

    fun reinitializeData(){
        _score = 0
        _currentWordCount = 0
        wordsList.clear()
        getNextWord()
    }


}