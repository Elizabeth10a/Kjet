package com.eliza.lifecycle.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleService
import com.eliza.lifecycle.R


class MyGpsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gps)
        findViewById<Button>(R.id.xml_gps_btn_start).setOnClickListener {
            startService(Intent(this, MyGpsService::class.java))
        }
        findViewById<Button>(R.id.xml_gps_btn_stop).setOnClickListener {
            stopService(Intent(this, MyGpsService::class.java))

        }

    }

}

class MyGpsService : LifecycleService {

    constructor() {
        Log.e("MyGpsService", "==MyGpsService==")
        lifecycle.addObserver(MyGpsObserver(this))
    }

}


class MyGpsObserver(private var context: Context) : LifecycleEventObserver {
    private lateinit var locationManager: LocationManager
    private lateinit var myLocationListener: MyLocationListener


    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> let {
                locationManager =
                    context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
                myLocationListener = MyLocationListener()
                Log.e("MyGpsObserver", "== LocationManager ==")

//判断权限
                if (ActivityCompat.checkSelfPermission
                        (context,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission
                        (context,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                ) {


                    return
                }
                Log.e("MyGpsObserver", "== locationManager.requestLocationUpdates ==")

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    2000,
                    0.2f,
                    myLocationListener)

            }
            Lifecycle.Event.ON_DESTROY -> let {
                locationManager.removeUpdates(myLocationListener)
                Log.d("MyGpsObserver", "== locationManager.removeUpdates ==")
            }
        }

    }

    companion object {

        /**
         * 监听器
         */
        class MyLocationListener : LocationListener {
            override fun onLocationChanged(p0: Location) {
                Log.d("MyLocationListener", "==onLocationChanged==：${p0.toString()}")
            }
        }
    }

}