package com.dansys.lab02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import org.greenrobot.eventbus.EventBus

class Fragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)

        val button: Button = view.findViewById(R.id.button)
        button.setOnClickListener {
            EventBus.getDefault().post(OpenFragment3Event())
        }
        return view
    }
}