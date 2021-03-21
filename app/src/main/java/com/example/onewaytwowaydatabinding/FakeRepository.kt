package com.example.onewaytwowaydatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object  FakeRepository {

    private val fruitName: List<String> = listOf(
        "Apple", "Pineapple", "kiwi",
        "mango", "Grapes", "Fig", "Strawberry"
    )

    private val _currentRandomFruitName = MutableLiveData<String>()
    val currentRandomFruitName : LiveData<String> get() = _currentRandomFruitName

    init{
        _currentRandomFruitName.value = fruitName.first()
    }

    fun getRandomFruitName() : String{
        val random = Random()
        return fruitName[random.nextInt(fruitName.size)]
    }

    fun changeCurrentRandomFruitName(){
        _currentRandomFruitName.value = getRandomFruitName()
    }

}