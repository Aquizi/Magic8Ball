package com.bignerdranch.android.magic8ball

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

    private var randNum = 0

    val currentResponseText: Int
        get() = responseBank[randNum].textResId

    fun getRandNum():Int{
        randNum = (Math.random() * 10).toInt()
        return randNum
    }

}