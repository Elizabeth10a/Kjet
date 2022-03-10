package com.eliza.lifecycle.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 3/10/22
 * @Software: Android Studio
 */
class Application : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())
    }

}

class ApplicationObserver : LifecycleEventObserver {
    val TAG = this::class.java.name
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> let { Log.e(TAG, "ON_CREATE") }//只会调用一次
            Lifecycle.Event.ON_START -> let { Log.e(TAG, "ON_START") }
            Lifecycle.Event.ON_RESUME -> let { Log.e(TAG, "ON_RESUME") }
            Lifecycle.Event.ON_PAUSE -> let { Log.e(TAG, "ON_PAUSE") }
            Lifecycle.Event.ON_STOP -> let { Log.e(TAG, "ON_STOP") }
            Lifecycle.Event.ON_DESTROY -> let { Log.e(TAG, "ON_DESTROY") }//永远不会被调用
        }
    }

}