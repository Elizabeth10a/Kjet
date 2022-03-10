package com.eliza.databinding.sub.model


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 3/10/22
 * @Software: Android Studio
 */
data class User(
    var name: String,
    var age: Int,
)

public class StarUtils {

    companion object {
        @JvmStatic
        fun getAge(star: Int): String {
            return when (star) {
                1 -> "One Age"
                2 -> "Two Age"
                3 -> "Three Age"
                4 -> "Four Age"
                5 -> "Five Age"
                else -> "One Age"
            }
        }
    }
}