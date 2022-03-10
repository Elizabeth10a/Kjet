package com.eliza.databinding.ba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.databinding.R
import com.example.android.databinding.databinding.BaActivityMainBinding

class BaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ba_activity_main)
        val baActivityMainBinding =
            DataBindingUtil.setContentView<BaActivityMainBinding>(this, R.layout.ba_activity_main)

        baActivityMainBinding.netImgUrl =
            "https://th.bing.com/th/id/OIP.S3QOsgnlzrpbpAdOXF4YMAHaEo?w=290&h=181&c=7&r=0&o=5&pid=1.7"

        baActivityMainBinding.localImg = R.drawable.ic_whatshot_black_96dp
    }
}