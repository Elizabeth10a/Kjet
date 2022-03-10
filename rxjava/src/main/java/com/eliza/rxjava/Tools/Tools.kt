package com.eliza.rxjava.Tools


import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class Tools {
    companion object {
        fun ToastTools(context: Context, info: String) {
            Toast.makeText(context, info, Toast.LENGTH_SHORT).show()
        }

        fun LogTools(tag: String, info: String, status: Int? = null) {

            when (status) {
                null -> Log.e(tag, info)
                0 -> Log.e(tag, info)
                1 -> Log.d(tag, info)
                2 -> Log.i(tag, info)
                3 -> Log.v(tag, info)
                else -> Log.e(tag, info)


            }

        }


        fun LogAll(context: Context, tag: String, info: String) {
            Toast.makeText(context, info, Toast.LENGTH_SHORT).show()
            Log.d(tag, info)
        }

        //打开摄像头

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private fun getPermissions(context: Context, activity: Activity) {
            // 要申请的权限
            val permissions = arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE,
                Manifest.permission.CAMERA, Manifest.permission.ACCESS_COARSE_LOCATION
            )
// 版本判断。当手机系统大于 23 时，才有必要去判断权限是否获取
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // 检查该权限是否已经获取
                var i =
                    ContextCompat.checkSelfPermission(context.applicationContext, permissions[0])
                var l =
                    ContextCompat.checkSelfPermission(context.applicationContext, permissions[1])
                var m =
                    ContextCompat.checkSelfPermission(context.applicationContext, permissions[2])
                var n =
                    ContextCompat.checkSelfPermission(context.applicationContext, permissions[3])
                // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
                if (i != PackageManager.PERMISSION_GRANTED ||
                    l != PackageManager.PERMISSION_GRANTED ||
                    m != PackageManager.PERMISSION_GRANTED ||
                    n != PackageManager.PERMISSION_GRANTED
                ) {
                    // 如果没有授予该权限，就去提示用户请求
                    ActivityCompat.requestPermissions(activity, permissions, 321);
                }

            }
        }
    }
}