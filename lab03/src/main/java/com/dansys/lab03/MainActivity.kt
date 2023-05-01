package com.dansys.lab03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1:Button=findViewById(R.id.button1)
        val button2:Button=findViewById(R.id.button2)
        val button3:Button=findViewById(R.id.button3)
        val button4:Button=findViewById(R.id.button4)

        button1.setOnClickListener { showToast("Button 1 clicked") }
        button2.setOnClickListener { showToast("Button 2 clicked") }
        button3.setOnClickListener { showToast("Button 3 clicked") }
        button4.setOnClickListener { showToast("Button 4 clicked") }

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}