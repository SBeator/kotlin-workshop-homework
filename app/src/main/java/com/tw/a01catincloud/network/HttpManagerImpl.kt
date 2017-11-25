package com.tw.a01catincloud.network

import com.tw.a01catincloud.model.GatNearbyCatResponse
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by xxzeng on 16/11/2017.
 */

class HttpManagerImpl : HttpManager {
    override fun getCat(callback: Subscriber<GatNearbyCatResponse>) {
        CatService.getCatService()
                .getNearbyCat()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback)
    }

}