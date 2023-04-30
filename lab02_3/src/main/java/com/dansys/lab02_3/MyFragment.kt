package com.dansys.lab02_3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MyFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            // Отправляем сообщение на шину событий
            EventBus.getDefault().post(MessageEvent("Hello from MyFragment!"))
        }
    }

    // Обработчик событий
    @Subscribe(threadMode = ThreadMode.MAIN)
    override fun onEvent(event: Any?) {
        if (event is MessageEvent) {
            // Обработка события здесь
            Log.d("MyFragment", "Received message: ${event.message}")
        }
    }

}