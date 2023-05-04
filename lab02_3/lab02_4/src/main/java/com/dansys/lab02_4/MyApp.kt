package com.dansys.lab02_4

import android.app.Application
import com.squareup.otto.Bus

class MyApp : Application() {
    companion object {
        lateinit var bus: Bus
    }

    override fun onCreate() {
        super.onCreate()
        bus = Bus()
    }
}