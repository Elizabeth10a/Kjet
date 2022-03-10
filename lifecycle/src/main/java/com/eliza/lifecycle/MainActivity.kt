package com.eliza.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    lateinit var chronometer: Chronometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chronometer = findViewById<Chronometer>(R.id.main_Chronometer)

    }

    override fun onResume() {
        super.onResume()

        chronometer.start()
    }

    override fun onPause() {
        super.onPause()

        chronometer.stop()
    }
}