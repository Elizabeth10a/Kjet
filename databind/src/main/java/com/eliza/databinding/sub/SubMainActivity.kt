package com.eliza.databinding.sub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.eliza.databinding.sub.model.User
import com.example.android.databinding.R
import com.example.android.databinding.databinding.SubMainActivityBinding


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 3/10/22
 * @Software: Android Studio
 */

/**
 * main  include tv
 * main data-->tv
 */
class SubMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置行为
        val subMainActivityBinding = DataBindingUtil.setContentView(
            this, R.layout.sub_main_activity) as SubMainActivityBinding
        subMainActivityBinding.user = User("法外狂吐", 4)

    }


}