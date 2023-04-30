package com.dansys.lab02;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dansys.lab02.*
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : AppCompatActivity() {

    override fun onStart(){
        super.onStart()
        EventBus.getDefault().register(this)

    }

    override fun onStop() {
        EventBus.getDefault().unregister(this)
        super.onStop()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onOpenFragment2Event(event: OpenFragment2Event) {
        openFragment2()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onOpenFragment3Event(event: OpenFragment3Event) {
        openFragment3()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, Fragment1())
            .commit()
    }

    fun openFragment2() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, Fragment2())
            .addToBackStack(null)
            .commit()
    }

    fun openFragment3() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, Fragment3())
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }


}