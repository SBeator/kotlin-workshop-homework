package com.tw.a01catincloud.network

import com.tw.a01catincloud.model.GatNearbyCatResponse
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by xxzeng on 16/11/2017.
 */

class HttpsManagerFactory  {
    companion object {
        private val sInstance: HttpManager = HttpManagerImpl()

        fun getMeetingHttpManager(): HttpManager {
            return sInstance
        }
    }

}