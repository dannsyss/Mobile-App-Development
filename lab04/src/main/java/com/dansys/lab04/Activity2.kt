package com.dansys.lab04

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class Activity2 : AppCompatActivity() {
    private var dateInMillis: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val datePickerButton = findViewById<Button>(R.id.datepicker_button)
        datePickerButton.setOnClickListener {
            showDatePicker()
        }

        val okButton = findViewById<Button>(R.id.ok_button)
        okButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("date", dateInMillis)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                calendar.set(year, month, dayOfMonth)
                showTimePicker(calendar.timeInMillis)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun showTimePicker(dateInMillis: Long) {
        val calendar = Calendar.getInstance()
        TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                calendar.set(Calendar.MINUTE, minute)
                this.dateInMillis = calendar.timeInMillis
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        ).show()
    }
}