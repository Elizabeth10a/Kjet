/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.eliza.livedata

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class LiveDataActivity : AppCompatActivity() {

    lateinit var numVm: NumVm

    /*
    * 在大多数情况下，应用组件的 onCreate() 方法是开始观察 LiveData 对象的正确着手点，原因如下：
        确保系统不会从 Activity 或 Fragment 的 onResume() 方法进行冗余调用。
        确保 Activity 或 Fragment 变为活跃状态后具有可以立即显示的数据。
             一旦应用组件处于 STARTED 状态，就会从它正在观察的 LiveData 对象接收最新值。
             只有在设置了要观察的 LiveData 对象时，才会发生这种情况。
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata)

        val tv = findViewById<TextView>(R.id.vm_main_tv)
        numVm = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory(application)).get(NumVm::class.java)

        tv.text = numVm.getCurrent().value.toString()
        val btn = findViewById<Button>(R.id.vm_main_btn)


        numVm.getCurrent().observe(this) { t ->
            t ?: let { tv.text = 0.toString() }
            tv.text = t.toString()
        }
        startTimer()

    }


    private fun startTimer() {

        Timer().schedule(
            object : TimerTask() {
                override fun run() {
                    //  非UI线程 postValue
                    numVm.getCurrent().postValue(numVm.getCurrent().value!!.plus(1))
                }
            }, 1000, 1000
        )


    }
}


