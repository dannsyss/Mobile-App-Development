package com.dansys.lab02_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // создаем экземпляр фрагмента и добавляем его в контейнер
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ParentFragment())
            .commit()
    }
}