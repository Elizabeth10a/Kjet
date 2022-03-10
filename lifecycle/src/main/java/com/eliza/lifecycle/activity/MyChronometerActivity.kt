package com.eliza.lifecycle.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.eliza.lifecycle.R

class MyChronometerActivity : AppCompatActivity() {

    lateinit var chronometer: MyChronometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chronometer)

        chronometer = findViewById<MyChronometer>(R.id.main_Chronometer)
        lifecycle.addObserver(chronometer)

    }

}
/**
 * 解藕 页面与组件
 */
class MyChronometer(context: Context?, attrs: AttributeSet?) : Chronometer(context, attrs),
    LifecycleEventObserver {
    private var elapsedTime = 0.toLong()

    //    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME) 过时
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {

            Lifecycle.Event.ON_RESUME -> let {
                base = SystemClock.elapsedRealtime() - elapsedTime
                start()
            }
            Lifecycle.Event.ON_PAUSE ->
                let {
                    elapsedTime = SystemClock.elapsedRealtime() - base
                    stop()
                }

            else -> let { Toast.makeText(context, "--onStateChanged--", Toast.LENGTH_SHORT).show() }
        }
    }

}