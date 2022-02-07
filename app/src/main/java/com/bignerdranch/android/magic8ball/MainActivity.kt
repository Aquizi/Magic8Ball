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
        val responseTextResId = magic8BallViewModel.currentResponseText
        responseTextView.setText(responseTextResId)
        responseTextView.visibility = View.VISIBLE
    }

}