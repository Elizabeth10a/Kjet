package com.eliza.viewmodel

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.eliza.viewmodel.vm.AddNumVm

/*
*
* 数据 --- vm --- activity
*
* model -- vm    ---      view ---
*           |-- liceData---|数据发生变化时 ，livedata 进通知
* */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}

