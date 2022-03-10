package com.eliza.databinding


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


    }
}