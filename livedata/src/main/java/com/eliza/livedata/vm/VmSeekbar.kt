package com.eliza.livedata.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 3/10/22
 * @Software: Android Studio
 */

/*
*
* 实现 两个 fg 之间数据互通*/
class VmSeekbar : ViewModel() {

    private var progress: MutableLiveData<Int> = MutableLiveData<Int>()

    init {
        progress.value = 0

    }

    fun getProgress(): MutableLiveData<Int> {
        return progress
    }

}