package com.eliza.databinding.sample.handle

import android.content.Context
import android.view.View
import com.eliza.databinding.Tools


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 3/10/22
 * @Software: Android Studio
 */
class OnClickHandle {
    lateinit var context: Context

    constructor(context: Context) {
        this.context = context
    }

    fun buttonOnClick(view: View) {
        Tools.LogAll(context, this::class.java.name, "I like")
    }
}