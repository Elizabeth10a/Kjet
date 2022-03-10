package com.eliza.rxjava.Tools

import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 3/3/22
 * @Software: Android Studio
 */
@GlideModule
class GlideModel : AppGlideModule() {
    override fun isManifestParsingEnabled(): Boolean {
        return true
    }
}