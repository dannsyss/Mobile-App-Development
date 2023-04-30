package com.dansys.lab02_3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class BaseFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Регистрируем этот фрагмент как слушателя событий
        EventBus.getDefault().register(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Отменяем регистрацию слушателя при уничтожении фрагмента
        EventBus.getDefault().unregister(this)
    }

    // Обработчик событий
    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onEvent(event: Any?) {
        // Обработка события здесь
    }

    /**
     * Получение View-элементов без findViewById()
     */
    protected inline fun <reified T : View> view(id: Int): Lazy<T> {
        return lazy { view!!.findViewById<T>(id) }
    }
}