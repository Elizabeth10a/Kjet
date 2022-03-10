package com.eliza.databinding.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.eliza.databinding.sample.model.Idol
import com.example.android.databinding.R
import com.example.android.databinding.databinding.SampleMainActivityBinding


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 3/10/22
 * @Software: Android Studio
 */
class MainSampleActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //创建操作文件的对象
        val sampleMainActivityBinding = DataBindingUtil.setContentView(
            this, R.layout.sample_main_activity) as SampleMainActivityBinding
        sampleMainActivityBinding.idol = Idol("法外狂吐", 4)
    }
}