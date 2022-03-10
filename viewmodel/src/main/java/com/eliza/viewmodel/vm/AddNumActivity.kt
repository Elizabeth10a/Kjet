package com.eliza.viewmodel.vm

import android.app.Application
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eliza.viewmodel.R

/*
*
* 数据 --- vm --- activity
* 保存数据
*
* 不要向ViewModel中传入Context,会导致内存泄漏
    如果要使用Context，请使用AndroidViewModel中的Application

* */
class AddNumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.main_tv)

        val numVm = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory(application)).get(AddNumVm::class.java)

        findViewById<TextView>(R.id.main_to_btn).setOnClickListener {
            tv.text = numVm.number++.toString()
        }
    }
}

class AddNumVm : ViewModel() {
    var number: Int = 0
}

// 传入 application
class AddNumVmAndroid(application: Application) : AndroidViewModel(application) {
    var number: Int = 0
}