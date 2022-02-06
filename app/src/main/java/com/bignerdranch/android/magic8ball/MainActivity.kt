package com.bignerdranch.android.magic8ball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private val magic8BallViewModel: Magic8BallViewModel by lazy {
        ViewModelProviders.of(this).get(Magic8BallViewModel::class.java)
    }

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

    private lateinit var triggerButton: Button
    private lateinit var responseTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider: ViewModelProvider = ViewModelProviders.of(this)
        val magic8BallViewModel = provider.get(Magic8BallViewModel::class.java)

        triggerButton = findViewById(R.id.trigger_button)
        responseTextView = findViewById(R.id.response_text)

        triggerButton.setOnClickListener {
            getResponse()
        }
    }

   private fun getResponse(){
        val responseTextResId = responseBank[(Math.random() * 10).toInt()].textResId
        responseTextView.setText(responseTextResId)
        responseTextView.visibility = View.VISIBLE
    }

}