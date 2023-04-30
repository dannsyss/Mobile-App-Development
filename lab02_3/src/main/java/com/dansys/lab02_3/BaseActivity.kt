package com.dansys.lab02_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Регистрируем эту активити как слушателя событий
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()

        // Отменяем регистрацию слушателя при уничтожении активити
        EventBus.getDefault().unregister(this)
    }

    // Обработчик событий
    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onEvent(event: Any?) {
        // Обработка события здесь
    }
}