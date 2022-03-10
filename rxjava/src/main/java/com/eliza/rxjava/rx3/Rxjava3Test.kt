package com.eliza.rxjava.rx3

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.eliza.rxjava.R
import com.eliza.rxjava.Tools.Tools
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observables.GroupedObservable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.roundToLong

class Rxjava3Test : AppCompatActivity(), View.OnClickListener {
    private lateinit var mSkipTest: TextView
    private lateinit var mDebounceTest: TextView
    private lateinit var mDistinctTest: TextView
    private lateinit var mElementAtTest: TextView
    private lateinit var mFilterTest: TextView
    private lateinit var mFirstTest: TextView
    private lateinit var mLastTest: TextView
    private lateinit var mIgnoreElementTest: TextView
    private lateinit var mOfTypeTest: TextView
    private lateinit var mSampleTest: TextView
    private lateinit var mThrottleFirstTest: TextView
    private lateinit var mThrottleLatestTest: TextView
    private lateinit var mTakeAndtakeLastTest: TextView
    private lateinit var mTimeoutTest: TextView
    private lateinit var mStartWithTest: TextView
    private lateinit var mMergeTest: TextView
    private lateinit var mZipTest: TextView
    private lateinit var mBufferTest: TextView
    private lateinit var mCastTest: TextView
    private lateinit var mConcatMapTest: TextView
    private lateinit var mConcatMapDelayErrorTest: TextView
    private lateinit var mConcatMapCompletableTest: TextView
    private lateinit var mConcatMapCompletableDelayErrorTest: TextView
    private lateinit var mFlatMapTest: TextView
    private lateinit var mFlattenAsFlowableAndFlattenAsObservableTest: TextView
    private lateinit var mGroupByTest: TextView
    private lateinit var mScanTest: TextView
    private lateinit var mWindowTest: TextView
    private lateinit var mOnErrorReturnTest: TextView
    private lateinit var mOnErrorReturnItemTest: TextView
    private lateinit var mOnExceptionResumeNextTest: TextView
    private lateinit var mRetryTest: TextView
    private lateinit var mRetryUntilTest: TextView

    @RequiresApi(api = Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava3_test)
        initView()
        // 对数据源过滤操作符
//        skipTest();
//        debounceTest();
//        distinctTest();
//        elementAtTest();
        // filterTest();
        // firstTest();
        // lastTest();
        // ignoreElementTest();
        // ofTypeTest();
        // sampleTest();
        // throttleFirstTest();
        // throttleLatestTest();
        // takeAndtakeLastTest();
        // timeoutTest();
        // 操作符:连接操作符，通过连接操作符，将多个被观察数据（数据源）连接在一起。
        // startWithTest();
        // mergeTest();
        // zipTest();
        // 变换操作符,变化数据源的数据，并转化为新的数据源。
        // bufferTest();
        // castTest();
        // concatMapTest();
        // concatMapDelayErrorTest();
        // concatMapCompletableTest();
        // concatMapCompletableDelayErrorTest();
        // flatMapTest();
        // flattenAsFlowableAndFlattenAsObservableTest();
        // groupByTest();
        // scanTest();
        // windowTest();
        // 错误处理操作符
        // onErrorReturnTest();
        // onErrorReturnItemTest();
        // onExceptionResumeNextTest();
        // retryTest();
        // retryUntilTest();
    }

    private fun initView() {
        mSkipTest = findViewById<View>(R.id.skipTest) as TextView
        mSkipTest.setOnClickListener(this)
        mDebounceTest = findViewById<View>(R.id.debounceTest) as TextView
        mDebounceTest.setOnClickListener(this)
        mDistinctTest = findViewById<View>(R.id.distinctTest) as TextView
        mDistinctTest.setOnClickListener(this)
        mElementAtTest = findViewById<View>(R.id.elementAtTest) as TextView
        mElementAtTest.setOnClickListener(this)
        mFilterTest = findViewById<View>(R.id.filterTest) as TextView
        mFilterTest.setOnClickListener(this)
        mFirstTest = findViewById<View>(R.id.firstTest) as TextView
        mFirstTest.setOnClickListener(this)
        mLastTest = findViewById<View>(R.id.lastTest) as TextView
        mLastTest.setOnClickListener(this)
        mIgnoreElementTest = findViewById<View>(R.id.ignoreElementTest) as TextView
        mIgnoreElementTest.setOnClickListener(this)
        mOfTypeTest = findViewById<View>(R.id.ofTypeTest) as TextView
        mOfTypeTest.setOnClickListener(this)
        mSampleTest = findViewById<View>(R.id.sampleTest) as TextView
        mSampleTest.setOnClickListener(this)
        mThrottleFirstTest = findViewById<View>(R.id.throttleFirstTest) as TextView
        mThrottleFirstTest.setOnClickListener(this)
        mThrottleLatestTest = findViewById<View>(R.id.throttleLatestTest) as TextView
        mThrottleLatestTest.setOnClickListener(this)
        mTakeAndtakeLastTest = findViewById<View>(R.id.takeAndtakeLastTest) as TextView
        mTakeAndtakeLastTest.setOnClickListener(this)
        mTimeoutTest = findViewById<View>(R.id.timeoutTest) as TextView
        mTimeoutTest.setOnClickListener(this)
        mStartWithTest = findViewById<View>(R.id.startWithTest) as TextView
        mStartWithTest.setOnClickListener(this)
        mMergeTest = findViewById<View>(R.id.mergeTest) as TextView
        mMergeTest.setOnClickListener(this)
        mZipTest = findViewById<View>(R.id.zipTest) as TextView
        mZipTest.setOnClickListener(this)
        mBufferTest = findViewById<View>(R.id.bufferTest) as TextView
        mBufferTest.setOnClickListener(this)
        mCastTest = findViewById<View>(R.id.castTest) as TextView
        mCastTest.setOnClickListener(this)
        mConcatMapTest = findViewById<View>(R.id.concatMapTest) as TextView
        mConcatMapTest.setOnClickListener(this)
        mConcatMapDelayErrorTest = findViewById<View>(R.id.concatMapDelayErrorTest) as TextView
        mConcatMapDelayErrorTest.setOnClickListener(this)
        mConcatMapCompletableTest = findViewById<View>(R.id.concatMapCompletableTest) as TextView
        mConcatMapCompletableTest.setOnClickListener(this)
        mConcatMapCompletableDelayErrorTest =
            findViewById<View>(R.id.concatMapCompletableDelayErrorTest) as TextView
        mConcatMapCompletableDelayErrorTest.setOnClickListener(this)
        mFlatMapTest = findViewById<View>(R.id.flatMapTest) as TextView
        mFlatMapTest.setOnClickListener(this)
        mFlattenAsFlowableAndFlattenAsObservableTest =
            findViewById<View>(R.id.flattenAsFlowableAndFlattenAsObservableTest) as TextView
        mFlattenAsFlowableAndFlattenAsObservableTest.setOnClickListener(this)
        mGroupByTest = findViewById<View>(R.id.groupByTest) as TextView
        mGroupByTest.setOnClickListener(this)
        mScanTest = findViewById<View>(R.id.scanTest) as TextView
        mScanTest.setOnClickListener(this)
        mWindowTest = findViewById<View>(R.id.windowTest) as TextView
        mWindowTest.setOnClickListener(this)
        mOnErrorReturnTest = findViewById<View>(R.id.onErrorReturnTest) as TextView
        mOnErrorReturnTest.setOnClickListener(this)
        mOnErrorReturnItemTest = findViewById<View>(R.id.onErrorReturnItemTest) as TextView
        mOnErrorReturnItemTest.setOnClickListener(this)
        mOnExceptionResumeNextTest = findViewById<View>(R.id.onExceptionResumeNextTest) as TextView
        mOnExceptionResumeNextTest.setOnClickListener(this)
        mRetryTest = findViewById<View>(R.id.retryTest) as TextView
        mRetryTest.setOnClickListener(this)
        mRetryUntilTest = findViewById<View>(R.id.retryUntilTest) as TextView
        mRetryUntilTest.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.skipTest ->         // skip（跳过）
                // 可以作用于Flowable,Observable，表示源发射数据前，跳过多少个。例如下面跳过前四个：
                skipTest()
            R.id.debounceTest ->         // debounce（去抖动）
                // 可作用于Flowable,Observable。在Android开发，通常为了防止用户重复点击而设置标记位，而通过RxJava的debounce操作符可以有效达到该效果。
                // 在规定时间内，用户重复点击只有最后一次有效，
                debounceTest()
            R.id.distinctTest ->         // distinct（去重）
                // 可作用于Flowable,Observable，去掉数据源重复的数据。
                distinctTest()
            R.id.elementAtTest ->         // elementAt（获取指定位置元素）
                // 可作用于Flowable,Observable，从数据源获取指定位置的元素，从0开始。
                elementAtTest()
            R.id.filterTest ->         // filter（过滤）
                // 可作用于 Flowable,Observable,Maybe,Single。在filter中返回表示发射该元素，返回false表示过滤该数据。
                filterTest()
            R.id.firstTest ->         // first(第一个)
                // 作用于 Flowable,Observable。发射数据源第一个数据，如果没有则发送默认值。
                firstTest()
            R.id.lastTest ->         // last(最后一个)
                // last、lastElement、lastOrError与fist、firstElement、firstOrError相对应。
                lastTest()
            R.id.ignoreElementTest ->         // ignoreElements & ignoreElement（忽略元素）
                // ignoreElements 作用于Flowable、Observable。ignoreElement作用于Maybe、Single。两者都是忽略掉数据，返回完成或者错误时间。
                ignoreElementTest()
            R.id.ofTypeTest ->         // ignoreElements & ignoreElement（忽略元素）
                // ignoreElements 作用于Flowable、Observable。ignoreElement作用于Maybe、Single。两者都是忽略掉数据，返回完成或者错误时间。
                ofTypeTest()
            R.id.sampleTest ->         // 作用于Flowable、Observable，在一个周期内发射最新的数据。
                sampleTest()
            R.id.throttleFirstTest ->         // throttleFirst & throttleLast & throttleWithTimeout
                // 作用于Flowable、Observable。throttleLast与smaple一致，而throttleFirst是指定周期内第一个数据。throttleWithTimeout与debounce一致。
                throttleFirstTest()
            R.id.throttleLatestTest ->         // 之所以拿出来单独说，我看不懂官网的解释。然后看别人的文章：throttleFirst+throttleLast的组合？开玩笑的吧。
                // 个人理解是：如果源的第一个数据总会被发射，然后开始周期计时，此时的效果就会跟throttleLast一致。
                throttleLatestTest()
            R.id.takeAndtakeLastTest ->         // 作用于Flowable、Observable，take发射前n个元素;takeLast发射后n个元素。
                takeAndtakeLastTest()
            R.id.timeoutTest ->         // timeout（超时）
                // 作用于Flowable、Observable、Maybe、Single、Completabl。后一个数据发射未在前一个元素发射后规定时间内发射则返回超时异常。
                timeoutTest()
            R.id.startWithTest ->         // 可作用于Flowable、Observable。将指定数据源合并在另外数据源的开头。
                startWithTest()
            R.id.mergeTest ->         // 可作用所有数据源类型，用于合并多个数据源到一个数据源。
                mergeTest()
            R.id.zipTest ->         // 可作用于Flowable、Observable、Maybe、Single。将多个数据源的数据一个一个的合并在一起哇。
                // 当其中一个数据源发射完事件之后，若其他数据源还有数据未发射完毕，也会停止。
                zipTest()
            R.id.bufferTest ->         // 作用于Flowable、Observable。指将数据源拆解含有长度为n的list的多个数据源，不够n的成为一个数据源。
                bufferTest()
            R.id.castTest ->         // 作用于Flowable、Observable、Maybe、Single。将数据元素转型成其他类型,转型失败会抛出异常。
                castTest()
            R.id.concatMapTest ->         // 作用于Flowable、Observable、Maybe。将数据源的元素作用于指定函数后，将函数的返回值有序的存在新的数据源。
                concatMapTest()
            R.id.concatMapDelayErrorTest ->         // 与concatMap作用相同，只是将过程发送的所有错误延迟到最后处理。
                concatMapDelayErrorTest()
            R.id.concatMapCompletableTest ->         // 作用于Flowable、Observable。与contactMap类似，不过应用于函数后，返回的是CompletableSource。
                // 订阅一次并在所有CompletableSource对象完成时返回一个Completable对象。
                concatMapCompletableTest()
            R.id.concatMapCompletableDelayErrorTest ->         // 与concatMapCompletable作用相同，只是将过程发送的所有错误延迟到最后处理。
                concatMapCompletableDelayErrorTest()
            R.id.flatMapTest ->         // 作用于Flowable、Observable、Maybe、Single。与contactMap类似，只是contactMap的数据发射是有序的，而flatMap是无序的。
                flatMapTest()
            R.id.flattenAsFlowableAndFlattenAsObservableTest ->         // 作用于Maybe、Single，将其转化为Flowable，或Observable。
                flattenAsFlowableAndFlattenAsObservableTest()
            R.id.groupByTest ->         // 作用于Flowable、Observable。根据一定的规则对数据源进行分组
                groupByTest()
            R.id.scanTest ->         // 作用于Flowable、Observable。对数据进行相关联操作，例如聚合等。
                scanTest()
            R.id.windowTest ->         // 对数据源发射出来的数据进行收集，按照指定的数量进行分组，以组的形式重新发射。
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    windowTest()
                }
            R.id.onErrorReturnTest ->         // 作用于Flowable、Observable、Maybe、Single。但调用数据源的onError函数后会回到该函数，可对错误进行处理，然后返回值，会调用观察者onNext()继续执行，执行完调用onComplete()函数结束所有事件的发射。
                onErrorReturnTest()
            R.id.onErrorReturnItemTest ->         // 与onErrorReturn类似，onErrorReturnItem不对错误进行处理，直接返回一个值。
                onErrorReturnItemTest()
            R.id.onExceptionResumeNextTest ->         // 可作用于Flowable、Observable、Maybe。onErrorReturn发生异常时，回调onComplete()函数后不再往下执行，
                // 而onExceptionResumeNext则是要在处理异常的时候返回一个数据源，然后继续执行，如果返回null，则调用观察者的onError()函数。
                // onExceptionResumeNext操作符也是类似的，只是捕获Exception。
                onExceptionResumeNextTest()
            R.id.retryTest ->         // 可作用于所有的数据源，当发生错误时，数据源重复发射item，直到没有异常或者达到所指定的次数。
                retryTest()
            R.id.retryUntilTest ->         // 作用于Flowable、Observable、Maybe。与retry类似，但发生异常时，返回值是false表示继续执行(重复发射数据)，true不再执行,但会调用onError方法。
                // retryWhen与此类似，但其判断标准不是BooleanSupplier对象的getAsBoolean()函数的返回值。而是返回的
                // Observable或Flowable是否会发射异常事件。
                retryUntilTest()
            else -> {}
        }
    }

    /**
     * skip（跳过）
     * 可以作用于Flowable,Observable，表示源发射数据前，跳过多少个。例如下面跳过前四个：
     */
    private fun skipTest() {
        val source = Observable.just(1, 2, 3, 4, 5, 6)
        source.skip(4).subscribe { integer: Int ->
            Tools.LogTools(TAG, "skipTest, accept: $integer")
        }
        // skipLast(n)操作表示从流的尾部跳过n个元素。
        source.skipLast(4).subscribe { integer: Int ->
            Tools.LogTools(
                TAG,
                "skipTest, accept: $integer"
            )
        }
        //    打印结果：1 2 3 4 5 6
    }

    /**
     * debounce（去抖动）

     * 可作用于Flowable,Observable。在Android开发，通常为了防止用户重复点击而设置标记位，而通过RxJava的debounce操作符可以有效达到该效果。
     * 在规定时间内，用户重复点击只有最后一次有效，
     */
    private fun debounceTest() {
        val source = Observable.create { emitter: ObservableEmitter<String> ->
            emitter.onNext("A")
            Thread.sleep(1500)
            emitter.onNext("B")
            Thread.sleep(500)
            emitter.onNext("C")
            Thread.sleep(250)
            emitter.onNext("D")
            Thread.sleep(2000)
            emitter.onNext("E")
            emitter.onComplete()
        }
        source
            .subscribeOn(Schedulers.io())
            .debounce(1, TimeUnit.SECONDS)
            /*
            * public final void blockingSubscribe(Consumer<? super T> onNext,
                Consumer<? super Throwable > onError,
                Action onComplete)*/
            .blockingSubscribe(
                { item: String -> Tools.LogTools(TAG, "debounceTest, accept: $item") },
                { obj: Throwable -> obj.printStackTrace() }
            ) {
                Tools.LogTools(TAG, "onComplete")
            }

        // 打印：A D E onComplete
        // 上文代码中，数据源以一定的时间间隔发送A,B,C,D,E。操作符debounce的时间设为1秒，发送A后1.5秒并没有发射其他数据，所以A能成功发射。
        // 发射B后，在1秒之内，又发射了C和D,在D之后的2秒才发射E,所有B、C都失效，只有D有效；而E之后已经没有其他数据流了，所有E有效。
    }

    /**
     * distinct（去重）
     * 可作用于Flowable,Observable，去掉数据源重复的数据。
     */
    private fun distinctTest() {
        Observable.just(2, 3, 4, 4, 2, 1).distinct().subscribe { integer: Int ->
            Tools.LogTools(TAG, "distinctTest, accept: $integer", 1)
        }

        // 打印:2 3 4 1
        // distinctUntilChanged()去掉相邻重复数据。
        Observable.just(1, 1, 2, 1, 2, 3, 3, 4).distinctUntilChanged().subscribe { integer: Int ->
            Tools.LogTools(TAG, "distinctTest, accept: $integer")
        }
        // 打印：1 2 1 2 3 4
    }

    /**
     * elementAt（获取指定位置元素）
     *

     * 可作用于Flowable,Observable，从数据源获取指定位置的元素，从0开始。
     */
    private fun elementAtTest() {
        Observable.just(2, 4, 3, 1, 5, 8)
            .elementAt(0)
            .subscribe { integer: Int ->
                Tools.LogTools(TAG, "elementAtTest, accept: $integer")
            }
        // 打印：2
        // elementAtOrError：指定元素的位置超过数据长度，则发射异常。
        val source = Observable.just("Kirk", "Spock", "Chekov", "Sulu")
        val element = source.elementAtOrError(4)
        element.subscribe(
            { name: String ->
                Tools.LogTools(TAG, "onSuccess will not be printed!")
            }
        ) { error: Throwable ->
            Tools.LogTools(
                TAG,
                "distinctTest, error: " + error.message
            )
        }
        // 打印：onSuccess will not be printed!
    }

    /**
     * filter（过滤）
     *
     *
     * 可作用于 Flowable,Observable,Maybe,Single。在filter中返回表示发射该元素，返回false表示过滤该数据。
     */
    private fun filterTest() {
        Observable.just(1, 2, 3, 4, 5, 6).filter { x: Int -> x % 2 == 0 }
            .subscribe { integer: Int ->
                Tools.LogTools(TAG, "filterTest, accept: $integer", 0)
            }
        // 打印：2 4 6
    }

    /**
     * first(第一个)
     *
     *
     * 作用于 Flowable,Observable。发射数据源第一个数据，如果没有则发送默认值。
     */
    private fun firstTest() {
        val source = Observable.just("A", "B", "C")
        val firstOrDefault = source.first("D")
        firstOrDefault.subscribe { s: String ->
            Tools.LogTools(TAG, "firstTest, accept: $s")
        }
        // 打印：A
        Observable.empty<String>().firstOrError().subscribe(
            { element: String? ->
                Tools.LogTools(TAG, "firstTest, onSuccess will not be printed!")
            }
        ) { error: Throwable ->
            Tools.LogTools(TAG, "firstTest, error: " + error.message)

        }
        // 打印：onError: java.util.NoSuchElementException
        // 和firstElement的区别是first返回的是Single，而firstElement返回Maybe。
        // firstOrError在没有数据会返回异常。
    }

    /**
     * last(最后一个)
     *
     *
     * last、lastElement、lastOrError与fist、firstElement、firstOrError相对应。
     */
    private fun lastTest() {
        val source = Observable.just("A", "B", "C")
        val lastOrDefault = source.last("D")
        lastOrDefault.subscribe { s: String ->
            Tools.LogTools(
                TAG,
                "lastTest, accept: $s"
            )
        }
        // 打印:C
        val source2 = Observable.just("A", "B", "C")
        val last = source2.lastElement()
        last.subscribe { s: String ->
            Tools.LogTools(
                TAG,
                "lastTest, accept: $s"
            )
        }
        // 打印:C
        val emptySource = Observable.empty<String>()
        val lastOrError = emptySource.lastOrError()
        lastOrError.subscribe(
            { element: String? ->
                Tools.LogTools(TAG, "lastTest, onSuccess will not be printed!")
            }
        ) { error: Throwable ->
            Tools.LogTools(
                TAG,
                "lastTest, error: " + error.message
            )
        }
        // 打印：onError: java.util.NoSuchElementException
    }

    /**
     * ignoreElements & ignoreElement（忽略元素）
     * ignoreElements 作用于Flowable、Observable。ignoreElement作用于Maybe、Single。两者都是忽略掉数据，返回完成或者错误时间。
     */
    private fun ignoreElementTest() {
        val source = Single.timer(1, TimeUnit.SECONDS)
        val completable = source.ignoreElement()
        completable.doOnComplete {
            Tools.LogTools(TAG, "Single.timer , Done!", 0)
        }.blockingAwait()

        // 1秒后打印：Donde!
        val source2 = Observable.intervalRange(1, 3, 1, 2, TimeUnit.SECONDS)
        val completable2 = source2.ignoreElements()
        completable2.doOnComplete {
            Tools.LogTools(TAG, " Observable.intervalRange, Done!", 0)
        }.blockingAwait()
        //three 秒后打印：Done!
    }

    /**
     * ofType（过滤掉类型）
     *
     *
     * 作用于Flowable、Observable、Maybe、过滤掉类型。
     */
    private fun ofTypeTest() {
        val numbers = Observable.just<Number>(1, 4.0, 3, 2.71, 2f, 7)
        numbers.ofType(Int::class.java).subscribe { x: Int ->
            Tools.LogTools(TAG, "ofTypeTest, accept: $x")
        }
        // 打印:1 3 7
    }

    /** 作用于Flowable、Observable，在一个周期内发射最新的数据。  */
    private fun sampleTest() {
        val source = Observable.create { emitter: ObservableEmitter<String> ->
            emitter.onNext("A")
            Thread.sleep(500)
            emitter.onNext("B")
            Thread.sleep(200)
            emitter.onNext("C")
            Thread.sleep(800)
            emitter.onNext("D")
            Thread.sleep(600)
            emitter.onNext("E")
            emitter.onComplete()
        }
        source
            // 与debounce的区别是，sample是以时间为周期的发射，一秒又一秒内的最新数据。而debounce是最后一个有效数据开始。
            //A-----B-----C-----------D
            //0.5---0.2---0.8---------0.6
            //----1-------0.5----1----0.1
            .subscribeOn(Schedulers.io())
            .sample(1, TimeUnit.SECONDS)
            .blockingSubscribe(
                { item: String -> Tools.LogTools(TAG, "sampleTest, item: $item", 0) },
                { obj: Throwable -> obj.printStackTrace() }
            ) {
                Tools.LogTools(TAG, "sampleTest, onComplete", 2)
            }

        // 打印：C D onComplete
    }

    /**
     * throttleFirst & throttleLast & throttleWithTimeout
     * 作用于Flowable、Observable。
     * throttleLast与smaple一致，
     * 而throttleFirst是指定周期内第一个数据。
     * throttleWithTimeout与debounce一致。
     */
    private fun throttleFirstTest() {
        val source = Observable.create { emitter: ObservableEmitter<String> ->
            emitter.onNext("A")
            Thread.sleep(500)
            emitter.onNext("B")
            Thread.sleep(200)
            emitter.onNext("C")
            Thread.sleep(800)
            emitter.onNext("D")
            Thread.sleep(600)
            emitter.onNext("E")
            emitter.onComplete()
        }
        source
            .subscribeOn(Schedulers.io())
            .throttleFirst(1, TimeUnit.SECONDS)
            .blockingSubscribe(
                { item: String ->
                    Tools.LogTools(TAG, "throttleFirstTest, item: $item")
                },
                { obj: Throwable -> obj.printStackTrace() }
            ) {
                Tools.LogTools(TAG, "throttleFirstTest, onComplete")
            }
        // 打印:A D onComplete
        source
            .subscribeOn(Schedulers.io())
            .throttleLast(1, TimeUnit.SECONDS)
            .blockingSubscribe(
                { item: String ->
                    Tools.LogTools(TAG, "throttleFirstTest, item: $item", 2)
                },
                { obj: Throwable -> obj.printStackTrace() }
            ) {
                Tools.LogTools(TAG, "throttleFirstTest, onComplete", 2)
            }

        // 打印:C D onComplete
    }

    /**
     * 之所以拿出来单独说，我看不懂官网的解释。然后看别人的文章：throttleFirst+throttleLast的组合？开玩笑的吧
     * 个人理解是：如果源的第一个数据总会被发射，然后开始周期计时，此时的效果就会跟throttleLast一致。
     */
    private fun throttleLatestTest() {
        val source = Observable.create { emitter: ObservableEmitter<String> ->
            emitter.onNext("A")
            Thread.sleep(500)
            emitter.onNext("B")
            Thread.sleep(200)
            emitter.onNext("C")
            Thread.sleep(200)
            emitter.onNext("D")
            Thread.sleep(400)
            emitter.onNext("E")
            Thread.sleep(400)
            emitter.onNext("F")
            Thread.sleep(400)
            emitter.onNext("G")
            Thread.sleep(2000)
            emitter.onComplete()
        }
        source
            .subscribeOn(Schedulers.io())
            .throttleLatest(1, TimeUnit.SECONDS)
            .blockingSubscribe(
                { item: String ->
                    Tools.LogTools(
                        TAG,
                        "throttleLatestTest, item: $item"
                    )
                },
                { obj: Throwable -> obj.printStackTrace() }
            ) {
                Tools.LogTools(
                    TAG,
                    "throttleLatestTest, finished"
                )
            }
    }

    /** 作用于Flowable、Observable，take发射前n个元素;takeLast发射后n个元素。  */
    private fun takeAndtakeLastTest() {
        val source = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        source.take(4).subscribe { integer: Int ->
            Tools.LogTools(
                TAG,
                "takeAndtakeLastTest, accept: $integer"
            )
        }
        // 打印:1 2 3 4
        source.takeLast(4).subscribe { integer: Int ->
            Tools.LogTools(
                TAG,
                "takeAndtakeLastTest, accept: $integer"
            )
        }
        // 打印:7 8 9 10
    }

    /**
     * timeout（超时）
     *
     *
     * 作用于Flowable、Observable、Maybe、Single、Completabl。
     * 后一个数据发射未在前一个元素发射后规定时间内发射则返回超时异常。
     */
    private fun timeoutTest() {
        val source = Observable.create { emitter: ObservableEmitter<String> ->
            emitter.onNext("A")
            Thread.sleep(800)
            emitter.onNext("B")
            Thread.sleep(400)
            emitter.onNext("C")
            Thread.sleep(1200)
            emitter.onNext("D")
            emitter.onComplete()
        }
        source
            .timeout(1, TimeUnit.SECONDS)
            .subscribe(
                { item: String ->
                    Tools.LogTools(
                        TAG,
                        "timeoutTest, item: $item"
                    )
                },
                { error: Throwable ->
                    Tools.LogTools(
                        TAG,
                        "timeoutTest, error: $error"
                    )
                }
            ) {
                Tools.LogTools(
                    TAG,
                    "timeoutTest, onComplete will not be printed!"
                )
            }
        // 打印:
        // onNext: A
        // onNext: B
        // onNext: C
        // onError: java.util.concurrent.TimeoutException:
        // The source did not signal an event for 1 seconds
        // and has been terminated.
    }

    /** 可作用于Flowable、Observable。将指定数据源合并在另外数据源的开头。  */
    private fun startWithTest() {
        val names = Observable.just("Spock", "McCoy")
        val otherNames = Observable.just("Git", "Code", "8")
        names.startWith(otherNames).subscribe { item: String ->
            Tools.LogTools(
                TAG,
                "startWithTest, item: $item"
            )
        }

        // 打印：
        // RxJava: Git
        // RxJava: Code
        // RxJava: 8
        // RxJava: Spock
        // RxJava: McCo
    }

    /** 可作用所有数据源类型，用于合并多个数据源到一个数据源。  */
    private fun mergeTest() {
        val names = Observable.just("Hello", "world")
        val otherNames = Observable.just("Git", "Code", "8")
        Observable.merge(names, otherNames).subscribe { name: String ->
            Tools.LogTools(
                TAG,
                "mergeTest, name: $name"
            )
        }

        // 也可以是
        // names.mergeWith(otherNames).subscribe(name -> Log.d(TAG,name));

        // 打印：
        // RxJava: Hello
        // RxJava: world
        // RxJava: Git
        // RxJava: Code
        // RxJava: 8

        // merge在合并数据源时，如果一个合并发生异常后会立即调用观察者的onError方法，并停止合并。可通过mergeDelayError操作符，将发生的异常留到最后处理。
        val names2 = Observable.just("Hello", "world")
        val otherNames2 = Observable.just("Git", "Code", "8")
        val error2 = Observable.error<String>(NullPointerException("Error!"))
        Observable.mergeDelayError(names2, error2, otherNames2).subscribe(
            { name: String ->
                Tools.LogTools(
                    TAG,
                    "mergeTest, name: $name"
                )
            }
        ) { e: Throwable ->
            Tools.LogTools(TAG, "mergeTest, error: " + e.message)
        }

        // 打印：
        // RxJava: Hello
        // RxJava: world
        // RxJava: Git
        // RxJava: Code
        // RxJava: 8
        // RxJava: Error!
    }

    /**
     * 可作用于Flowable、Observable、Maybe、Single。
     * 将多个数据源的数据一个一个的合并在一起哇。当其中一个数据源发射完事件之后，若其他数据源还有数据未发射完毕，也会停止。
     */
    private fun zipTest() {
        val names = Observable.just("Hello", "world")
        val otherNames = Observable.just("Git", "Code", "8")
        names
            .zipWith(otherNames) { first: String, last: String -> "$first---$last" }
            .subscribe { item: String ->
                Tools.LogTools(
                    TAG,
                    "zipTest, accept: $item", 1
                )
            }

        // 打印：
        // RxJava: Hello-Git
        // RxJava: world-Code
    }

    /** 作用于Flowable、Observable。指将数据源拆解含有长度为n的list的多个数据源，不够n的成为一个数据源。  */
    private fun bufferTest() {
        Observable.range(0, 10)
            .buffer(4)
            .subscribe { buffer: List<Int?> ->
                Tools.LogTools(
                    TAG,
                    "bufferTest, accept: $buffer", 2
                )
            }
        // 打印:
        // [0, 1, 2, 3]
        // [4, 5, 6, 7]
        // [8, 9]
    }

    /** 作用于Flowable、Observable、Maybe、Single。将数据元素转型成其他类型,转型失败会抛出异常。  */
    private fun castTest() {
        val numbers = Observable.just<Number>(1, 4.0, 3f, 7, 12, 4.6, 5)
        numbers
            .filter { x: Number? ->
                Int::class.java.isInstance(
                    x
                )
            }
            .cast(Int::class.java)
            .subscribe { x: Int ->
                Tools.LogTools(
                    TAG,
                    "castTest, accept: $x", 2
                )
            }
        // prints:
        // 1
        // 7
        // 12
        // 5
    }

    /** 作用于Flowable、Observable、Maybe。
     * 将数据源的元素作用于指定函数后，将函数的返回值有序的存在新的数据源。  */
    private fun concatMapTest() {
        Observable.range(0, 5)
            .concatMap { i: Int ->
                val delay = (Math.random() * 2).roundToLong()
                Observable.timer(delay, TimeUnit.SECONDS)
                    .map { n: Long? -> i }
            }
            .blockingSubscribe { integer: Int ->
                Tools.LogTools(
                    TAG,
                    "concatMapTest, accept: $integer"
                )
            }
        // prints 01234
    }

    /** 与concatMap作用相同，只是将过程发送的所有错误延迟到最后处理。  */
    private fun concatMapDelayErrorTest() {
        Observable.intervalRange(1, 3, 0, 1, TimeUnit.SECONDS)
            .concatMapDelayError { x: Long ->
                if (x == 1L) {
                    return@concatMapDelayError Observable.error<Long>(
                        IOException(
                            "Something went wrong!"
                        )
                    )
                } else {
                    return@concatMapDelayError Observable.just(x, x * x)
                }
            }
            .blockingSubscribe(
                { x: Long ->
                    Tools.LogTools(
                        TAG,
                        "concatMapDelayErrorTest, accept: $x"
                    )
                }
            ) { error: Throwable ->
                Tools.LogTools(
                    TAG,
                    "concatMapDelayErrorTest, error: " + error.message
                )
            }
        // prints:
        // onNext: 2
        // onNext: 4
        // onNext: 3
        // onNext: 9
        // onError: Something went wrong!
    }

    /**
     * 作用于Flowable、Observable。与contactMap类似，
     * 不过应用于函数后，返回的是CompletableSource。订阅一次并在所有CompletableSource对象完成时返回一个Completable对象。
     */
    private fun concatMapCompletableTest() {
        val source = Observable.just(2, 1, 3)
        val completable = source.concatMapCompletable { x: Int ->
            Completable.timer(x.toLong(), TimeUnit.SECONDS)
                .doOnComplete {
                    Tools.LogTools(
                        TAG,
                        "concatMapCompletableTest, accept: $x"
                    )
                }
        }
        completable
            .doOnComplete {
                Tools.LogTools(
                    TAG,
                    "concatMapCompletableTest, Info: Processing of all items completed"
                )
            }
            .blockingAwait()

        // prints:
        // Info: Processing of item "2" completed
        // Info: Processing of item "1" completed
        // Info: Processing of item "3" completed
        // Info: Processing of all items completed
    }

    /** 与concatMapCompletable作用相同，只是将过程发送的所有错误延迟到最后处理。  */
    private fun concatMapCompletableDelayErrorTest() {
        val source = Observable.just(2, 1, 3)
        val completable = source.concatMapCompletableDelayError { x: Int ->
            if (x == 2) {
                return@concatMapCompletableDelayError Completable.error(
                    IOException("Processing of item \"$x\" failed!")
                )
            } else {
                return@concatMapCompletableDelayError Completable.timer(
                    1,
                    TimeUnit.SECONDS
                )
                    .doOnComplete {
                        Tools.LogTools(
                            TAG,
                            "concatMapCompletableDelayErrorTest, accept: $x"
                        )
                    }
            }
        }
        completable
            .doOnError { error: Throwable ->
                Tools.LogTools(
                    TAG,
                    "concatMapCompletableDelayErrorTest, error: " + error.message
                )
            }
            .onErrorComplete()
            .blockingAwait()

        // prints:
        // Info: Processing of item "1" completed
        // Info: Processing of item "3" completed
        // Error: Processing of item "2" failed!
    }

    /** 作用于Flowable、Observable、Maybe、Single。
     * 与contactMap类似，只是contactMap的数据发射是有序的，而flatMap是无序的。  */
    private fun flatMapTest() {
        Observable.just("A", "B", "C")
            .flatMap { a: String ->
                Observable.intervalRange(1, 3, 0, 1, TimeUnit.SECONDS)
                    .map { b: Long -> "($a, $b)" }
            }
            .blockingSubscribe { s: String ->
                Tools.LogTools(
                    TAG,
                    "flatMapTest, accept: $s"
                )
            }

        // prints (not necessarily in this order):
        // (A, 1)
        // (C, 1)
        // (B, 1)
        // (A, 2)
        // (C, 2)
        // (B, 2)
        // (A, 3)
        // (C, 3)
        // (B, 3)
    }

    /** 作用于Maybe、Single，将其转化为Flowable，或Observable。  */
    @SuppressLint("CheckResult")
    private fun flattenAsFlowableAndFlattenAsObservableTest() {
        val source = Single.just(2.0)
        val flowable = source.flattenAsFlowable { x: Double ->
            Arrays.asList(
                x,
                Math.pow(x, 2.0),
                Math.pow(x, 3.0)
            )
        }
        flowable.subscribe { x: Double ->
            Tools.LogTools(
                TAG,
                "flattenAsFlowableAndFlattenAsObservableTest, accept: $x"
            )
        }

        // prints:
        // onNext: 2.0
        // onNext: 4.0
        // onNext: 8.0
    }

    /** 作用于Flowable、Observable。根据一定的规则对数据源进行分组  */
    private fun groupByTest() {
        val animals = Observable.just(
            "Tiger", "Elephant", "Cat", "Chameleon", "Frog", "Fish", "Turtle", "Flamingo"
        )
        animals
            .groupBy(
                { animal: String ->
                    animal[0]
                }
            ) { obj: String -> obj.toUpperCase() }
            .concatMapSingle { obj: GroupedObservable<Char, String> -> obj.toList() }
            .subscribe { strings: List<String> ->
                for (string in strings) {
                    Tools.LogTools(
                        TAG,
                        "groupByTest, accept: $string"
                    )
                }
            }

        // prints:
        // [TIGER, TURTLE]
        // [ELEPHANT]
        // [CAT, CHAMELEON]
        // [FROG, FISH, FLAMINGO]
    }

    /** 作用于Flowable、Observable。对数据进行相关联操作，例如聚合等。  */
    private fun scanTest() {
        Observable.just(5, 3, 8, 1, 7)
            .scan(
                0
            ) { partialSum: Int, x: Int -> partialSum + x }
            .subscribe { integer: Int ->
                Tools.LogTools(
                    TAG,
                    "scanTest, accept: $integer"
                )
            }

        // prints:
        // 0
        // 5
        // 8
        // 16
        // 17
        // 24
    }

    /** 对数据源发射出来的数据进行收集，按照指定的数量进行分组，以组的形式重新发射。  */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("CheckResult")
    private fun windowTest() {
        Observable.range(
            1,
            4
        ) // Create windows containing at most 2 items, and skip 3 items before starting a new window.
            .window(2)
            .flatMapSingle { window: Observable<Int> ->
                window
                    .map { obj: Int -> obj.toString() }
                    .reduce(
                        StringJoiner(", ", "[", "]")
                    ) { obj: StringJoiner, newElement: String? ->
                        obj.add(
                            newElement
                        )
                    }
            }
            .subscribe { stringJoiner: StringJoiner ->
                Tools.LogTools(
                    TAG,
                    "windowTest, accept: $stringJoiner"
                )
            }

        // prints:
        // [1, 2]
        // [3, 4]
    }

    /**
     * 作用于Flowable、Observable、Maybe、Single。但调用数据源的onError函数后会回到该函数，可对错误进行处理，然后返回值，会调用观察者onNext()继续执行，执行完调用onComplete()函数结束所有事件的发射。
     */
    private fun onErrorReturnTest() {
        Single.just("2A").map { v: String ->
            v.toInt(
                10
            )
        }.onErrorReturn { error: Throwable? ->
            if (error is NumberFormatException) {
                return@onErrorReturn 0
            }
            throw IllegalArgumentException()
        }.subscribe(
            { integer: Int ->
                Tools.LogTools(
                    TAG,
                    "onErrorReturnTest, accept: $integer"
                )
            }
        ) { error: Throwable? ->
            Tools.LogTools(
                TAG,
                "onErrorReturnTest, onError should not be printed!"
            )
        }
        // prints 0
    }

    /** 与onErrorReturn类似，onErrorReturnItem不对错误进行处理，直接返回一个值。  */
    private fun onErrorReturnItemTest() {
        Single.just("2A").map { v: String ->
            v.toInt(
                10
            )
        }.onErrorReturnItem(0).subscribe(
            { integer: Int ->
                Tools.LogTools(
                    TAG,
                    "onErrorReturnItemTest, accept: $integer"
                )
            }
        ) { error: Throwable? ->
            Tools.LogTools(
                TAG,
                "onErrorReturnItemTest, onError should not be printed!"
            )
        }
        // prints 0
    }

    /**
     * 可作用于Flowable、Observable、Maybe。onErrorReturn发生异常时，回调onComplete()函数后不再往下执行，
     * 而onExceptionResumeNext则是要在处理异常的时候返回一个数据源，然后继续执行，如果返回null，则调用观察者的onError()函数。
     * onExceptionResumeNext操作符也是类似的，只是捕获Exception。
     */
    private fun onExceptionResumeNextTest() {
        Observable.create(
            ObservableOnSubscribe { e: ObservableEmitter<Int> ->
                e.onNext(1)
                e.onNext(2)
                e.onNext(3)
                e.onError(NullPointerException())
                e.onNext(4)
            })
            .onErrorResumeNext { throwable: Throwable? ->
                Tools.LogTools(
                    TAG,
                    "onExceptionResumeNextTest, onErrorResumeNext"
                )
                Observable.just(4)
            }
            .subscribe(
                object : Observer<Int> {
                    override fun onSubscribe(d: Disposable) {
                        Tools.LogTools(TAG, "onExceptionResumeNextTest, onSubscribe")
                    }

                    override fun onNext(integer: Int) {
                        Tools.LogTools(
                            TAG,
                            "onExceptionResumeNextTest, onNext: $integer"
                        )
                    }

                    override fun onError(e: Throwable) {
                        Tools.LogTools(TAG, "onExceptionResumeNextTest, onError: " + e.message)
                    }

                    override fun onComplete() {
                        Tools.LogTools(TAG, "onExceptionResumeNextTest, onComplete")
                    }
                })
    }

    /** 可作用于所有的数据源，当发生错误时，数据源重复发射item，直到没有异常或者达到所指定的次数。  */
    private fun retryTest() {
        val first = booleanArrayOf(true)
        Observable.create(
            ObservableOnSubscribe { e: ObservableEmitter<Int> ->
                e.onNext(1)
                e.onNext(2)
                if (first[0]) {
                    first[0] = false
                    e.onError(NullPointerException())
                }
            })
            .retry(9)
            .subscribe(
                object : Observer<Int> {
                    override fun onSubscribe(d: Disposable) {
                        Tools.LogTools(TAG, "retryTest, onSubscribe")
                    }

                    override fun onNext(integer: Int) {
                        Tools.LogTools(
                            TAG,
                            "retryTest, onNext: $integer"
                        )
                    }

                    override fun onError(e: Throwable) {
                        Tools.LogTools(TAG, "retryTest, onError: " + e.message)
                    }

                    override fun onComplete() {
                        Tools.LogTools(TAG, "retryTest, onComplete")
                    }
                })
    }

    /**
     * 作用于Flowable、Observable、Maybe。与retry类似，但发生异常时，返回值是false表示继续执行(重复发射数据)，true不再执行,但会调用onError方法。
     * retryWhen与此类似，但其判断标准不是BooleanSupplier对象的getAsBoolean()函数的返回值。而是返回的
     * Observable或Flowable是否会发射异常事件。
     */
    private fun retryUntilTest() {
        Observable.create(
            ObservableOnSubscribe { e: ObservableEmitter<Int> ->
                e.onNext(1)
                e.onNext(2)
                e.onError(NullPointerException())
                e.onNext(3)
                e.onComplete()
            })
            .retryUntil { true }
            .subscribe(
                object : Observer<Int> {
                    override fun onSubscribe(d: Disposable) {
                        Tools.LogTools(TAG, "retryUntilTest, onSubscribe")
                    }

                    override fun onNext(integer: Int) {
                        Tools.LogTools(
                            TAG,
                            "retryUntilTest, onNext: $integer"
                        )
                    }

                    override fun onError(e: Throwable) {
                        Tools.LogTools(TAG, "retryUntilTest, onError: " + e.message)
                    }

                    override fun onComplete() {
                        Tools.LogTools(TAG, "retryUntilTest, onComplete")
                    }
                })
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}