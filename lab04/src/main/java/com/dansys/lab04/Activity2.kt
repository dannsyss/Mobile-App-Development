package com.dansys.lab04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val name = intent.getStringExtra("name")
        nameTextView.text = "Hello, $name!"
    }
}