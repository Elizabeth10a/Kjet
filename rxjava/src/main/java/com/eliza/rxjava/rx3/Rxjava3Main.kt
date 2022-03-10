package com.eliza.rxjava.rx3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.eliza.rxjava.R
import com.eliza.rxjava.Tools.NetWorkUtils
import com.eliza.rxjava.Tools.Tools
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.net.URL
import java.util.concurrent.Flow


/*
* RX思维的学习，是一-劳永逸的
响应式编程:根据上一层的响应来I影响下一层的变化]
RxJava 是一个 基于事件流、实现异步操作的库
* */
class Rxjava3Main : AppCompatActivity() {

    var imgPath = "http://www.pp3.cn/uploads/20120418lw/13.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_rx3)
        val img = findViewById<ImageView>(R.id.rx3_main_img)
        val btn = findViewById<Button>(R.id.rx3_main_btn)

        Tools.ToastTools(
            this, "this device NetWork :${NetWorkUtils.isNetworkConnected(this)}"
        )
        btn.setOnClickListener {

            Tools.ToastTools(this, "Glide")
            Glide.with(this@Rxjava3Main).load(imgPath).fitCenter().into(img);

        }
        useRx(img)
    }

    fun createObservable(): Observable<Int> {
        // 1. 创建被观察者 Observable 对象
        // 1. 创建被观察者 Observable 对象
        /*   val observable: Observable<Int> = Observable.create(object : ObservableOnSubscribe<Int> {
               // create() 是 RxJava 最基本的创造事件序列的方法
               // 此处传入了一个 OnSubscribe 对象参数
               // 当 Observable 被订阅时，OnSubscribe 的 call() 方法会自动被调用，即事件序列就会依照设定依次被触发
               // 即观察者会依次调用对应事件的复写方法从而响应事件
               // 从而实现被观察者调用了观察者的回调方法 & 由被观察者向观察者的事件传递，即观察者模式
               // 2. 在复写的subscribe（）里定义需要发送的事件
               @Throws(Exception::class)
               override fun subscribe(emitter: ObservableEmitter<Int>) {
                   // 通过 ObservableEmitter类对象产生事件并通知观察者
                   // ObservableEmitter类介绍
                   // a. 定义：事件发射器
                   // b. 作用：定义需要发送的事件 & 向观察者发送事件
                   emitter.onNext(1)
                   emitter.onNext(2)
                   emitter.onNext(3)
                   emitter.onComplete()
               }
           })*/
        val observable: Observable<Int> = Observable.create { emitter ->
            /*    create() 是 RxJava 最基本的创造事件序列的方法
                此处传入了一个 OnSubscribe 对象参数
                当 Observable 被订阅时，OnSubscribe 的 call() 方法会自动被调用，即事件序列就会依照设定依次被触发
                    即观察者会依次调用对应事件的复写方法从而响应事件
                    从而实现被观察者调用了观察者的回调方法 & 由被观察者向观察者的事件传递，即观察者模式
                2. 在复写的subscribe（）里定义需要发送的事件
                 通过 ObservableEmitter类对象产生事件并通知观察者
                    ObservableEmitter类介绍
                    a. 定义：事件发射器
                    b. 作用：定义需要发送的事件 & 向观察者发送事件*/
            emitter.onNext(1)
            emitter.onNext(2)
            emitter.onNext(3)
            emitter.onComplete()
        }
        //        <--扩展：RxJava 提供了其他方法用于 创建被观察者对象Observable -->
        // 方法1：just(T...)：直接将传入的参数依次发送出来
        var obJust = Observable.just("A", "B", "C");
        // 方法2：from(T[]) / from(Iterable<? extends T>) : 将传入的数组 / Iterable 拆分成具体对象后，依次发送出来
        // 方法2：from(T[]) / from(Iterable<? extends T>) : 将传入的数组 / Iterable 拆分成具体对象后，依次发送出来
        val words = arrayOf("A", "B", "C")
        val obFrom: Observable<*> = Observable.fromArray(words)
        return observable
    }

    fun createObserver(): Observer<Int> {
//        <--方式1：采用Observer 接口 -->
        // 1. 创建观察者 （Observer ）对象
        val observer: Observer<Int> = object : Observer<Int> {
            // 2. 创建对象时通过对应复写对应事件方法 从而 响应对应事件
            // 观察者接收事件前，默认最先调用复写 onSubscribe（）
            override fun onSubscribe(d: Disposable) {
                Tools.LogTools(this@Rxjava3Main::class.java.name, "开始采用subscribe连接")
            }

            // 当被观察者生产Next事件 & 观察者接收到时，会调用该复写方法 进行响应
            override fun onNext(value: Int) {
                Tools.LogTools(this@Rxjava3Main::class.java.name, "对Next事件作出响应$value")
            }

            // 当被观察者生产Error事件& 观察者接收到时，会调用该复写方法 进行响应
            override fun onError(e: Throwable) {
                Tools.LogTools(this@Rxjava3Main::class.java.name, "对Error事件作出响应")
            }

            // 当被观察者生产Complete事件& 观察者接收到时，会调用该复写方法 进行响应
            override fun onComplete() {
                Tools.LogTools(this@Rxjava3Main::class.java.name, "对Complete事件作出响应")
            }
        }
        // 说明：Subscriber类 = RxJava 内置的一个实现了 Observer 的抽象类，对 Observer 接口进行了扩展


// 方式2：采用Subscriber 抽象类 -->
        // 说明：Subscriber类 = RxJava 内置的一个实现了 Observer 的抽象类，对 Observer 接口进行了扩展
        val subscriber: Flow.Subscriber<Int> = @RequiresApi(Build.VERSION_CODES.R)
        object : Flow.Subscriber<Int> {
            // 2. 创建对象时通过对应复写对应事件方法 从而 响应对应事件
            // 观察者接收事件前，默认最先调用复写 onSubscribe（）
            override fun onSubscribe(s: Flow.Subscription?) {
                Tools.LogTools(this@Rxjava3Main::class.java.name, "开始采用subscribe连接")
            }

            // 当被观察者生产Next事件 & 观察者接收到时，会调用该复写方法 进行响应
            override fun onNext(value: Int) {
                Tools.LogTools(this@Rxjava3Main::class.java.name, "对Next事件作出响应$value")
            }

            // 当被观察者生产Error事件& 观察者接收到时，会调用该复写方法 进行响应
            override fun onError(e: Throwable?) {
                Tools.LogTools(this@Rxjava3Main::class.java.name, "对Error事件作出响应")
            }

            // 当被观察者生产Complete事件& 观察者接收到时，会调用该复写方法 进行响应
            override fun onComplete() {
                Tools.LogTools(this@Rxjava3Main::class.java.name, "对Complete事件作出响应")
            }


        }
        return observer
    }

    fun useRx(img: ImageView) {

        //just 传入 xx 后面操作 xx
//被观察者（Observable）--> 订阅（Subscribe）--> 观察者（Observer）   {事件（Event）}
//        被观察者 （Observable） 通过 订阅（Subscribe） 按顺序发送事件 给观察者 （Observer）， 观察者（Observer） 按顺序接收事件 & 作出对应的响应动作
        Observable.just(imgPath)//起点



            //分配线程
            .subscribeOn(Schedulers.io())
//        关联--订阅
            .subscribe(object : Observer<String> {

                //订阅成功
                override fun onSubscribe(d: Disposable) {
                    Tools.LogTools(this::class.java.name, "--subscribe")


                }

                //上层给的响应
                override fun onNext(t: String) {

                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }


            })


    }


}

/*
*
*
角色	作用	类比
被观察者（Observable）	产生事件	顾客
观察者（Observer）	接收事件，并给出响应动作	厨房
订阅（Subscribe）	连接 被观察者 & 观察者	服务员
事件（Event）	被观察者 & 观察者 沟通的载体	菜式

作者：Carson带你学安卓
链接：https://www.jianshu.com/p/a406b94f3188
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*
* */