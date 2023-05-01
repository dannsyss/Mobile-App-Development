package com.dansys.lab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.name_edittext)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("name", nameEditText.text.toString())
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val dateInMillis = data?.getLongExtra("date", 0)
            val dateString = getTimeString(dateInMillis ?: 0)
            val textView = findViewById<TextView>(R.id.result_textview)
            textView.text = "Hello ${nameEditText.text}! Your chosen date is $dateString."
        }
    }

    private fun getTimeString(millis: Long): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = millis
        return DateFormat.getDateInstance().format(calendar.time)
    }
}