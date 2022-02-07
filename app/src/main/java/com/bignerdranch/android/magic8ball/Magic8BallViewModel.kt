package com.bignerdranch.android.magic8ball

import android.view.View
import androidx.lifecycle.ViewModel

class Magic8BallViewModel : ViewModel() {

    private val responseBank = listOf(
        Response(R.string.response_1),
        Response(R.string.response_2),
        Response(R.string.response_3),
        Response(R.string.response_4),
        Response(R.string.response_5),
        Response(R.string.response_6),
        Response(R.string.response_7),
        Response(R.string.response_8),
        Response(R.string.response_9),
        Response(R.string.response_10),
    )

    private var currentIndex = 0

    val currentResponseText: Int
        get() = responseBank[currentIndex].textResId

    fun getRandIndex():Int{
        currentIndex = (Math.random() * 10).toInt()
        return currentIndex
    }

}