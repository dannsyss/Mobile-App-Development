package com.dansys.lab02_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(),MainFragment.SomeFragmentClickListener{
    private val colors: Array<Int> =
        arrayOf(R.color.blue, R.color.green, R.color.colorColdYellow, R.color.colorColdPink)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.main_container,MainFragment())
            .commit()
    }

    override fun onChangeColorButtonClicked() {
        findViewById<ConstraintLayout>(R.id.main_container)
            .setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    colors[(0..colors.size-1).random()]
                )
            )
    }
}