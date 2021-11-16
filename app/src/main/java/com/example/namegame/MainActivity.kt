package com.example.namegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchPracticeModeActivity()
    }

    private fun launchPracticeModeActivity () {
        findViewById<Button>(R.id.practiceModeButton).setOnClickListener {
            val intent = Intent(this, PracticeModeActivity::class.java)
            startActivity(intent)
        }
    }
}