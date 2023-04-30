package com.dansys.lab02_3

import android.os.Bundle
import android.util.Log
import android.widget.Button
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MyActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            // Отправляем сообщение на шину событий
            EventBus.getDefault().post(MessageEvent("Hello from MyActivity!"))
        }
    }

    // Обработчик событий
    @Subscribe(threadMode = ThreadMode.MAIN)
    override fun onEvent(event: Any?) {
        if (event is MessageEvent) {
            // Обработка события здесь
            Log.d("MyActivity", "Received message: ${event.message}")
        }
    }
}