package com.eliza.databinding.sample.model


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 3/10/22
 * @Software: Android Studio
 */
data class Idol(
    var name: String,
    var star: Int,
)

public class StarUtils {

    companion object {
        @JvmStatic
        fun getStar(star: Int): String {
            return when (star) {
                1 -> "One star"
                2 -> "Two star"
                3 -> "Three star"
                4 -> "Four star"
                5 -> "Five star"
                else -> "One star"
            }
        }
    }
}