package com.eliza.rxjava

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.eliza.rxjava.rx2.observability.ui.UserActivity
import com.eliza.rxjava.rx3.Rxjava3Main
import com.eliza.rxjava.rx3.Rxjava3Test


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 3/3/22
 * @Software: Android Studio
 */
class Main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.main_to_rx2).setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }
        findViewById<Button>(R.id.main_to_rx3).setOnClickListener {
            startActivity(Intent(this, Rxjava3Main::class.java))

        }
        findViewById<Button>(R.id.main_to_rx3test).setOnClickListener {
            startActivity(Intent(this, Rxjava3Test::class.java))

        }

    }
}