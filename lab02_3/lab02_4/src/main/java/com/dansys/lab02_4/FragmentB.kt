package com.dansys.lab02_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.squareup.otto.Subscribe

class FragmentB : Fragment() {
private lateinit var textView: TextView

override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_b, container, false)

    textView = view.findViewById<TextView>(R.id.textView)
    return view
}

override fun onResume() {
    super.onResume()
    MyApp.bus.register(this)
}

override fun onPause() {
    super.onPause()
    MyApp.bus.unregister(this)
}

@Subscribe
fun onDataEvent(event: DataEvent) {
    textView.text = event.data
}
}