package com.eliza.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 3/10/22
 * @Software: Android Studio
 */
class NumVm : ViewModel() {
    private var current: MutableLiveData<Int> = MutableLiveData<Int>()

    init {
        current.value = 0
    }

    fun getCurrent(): MutableLiveData<Int> {
        return current
    }


}