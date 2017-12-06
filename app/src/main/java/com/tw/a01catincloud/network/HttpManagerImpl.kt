package com.tw.a01catincloud.network

import com.tw.a01catincloud.model.GatNearbyCatResponse
import com.tw.a01catincloud.model.GetSingleCatResponse
import com.tw.a01catincloud.model.PostLoginRequest
import com.tw.a01catincloud.model.PostLoginResponse
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by xxzeng on 16/11/2017.
 */

class HttpManagerImpl : HttpManager {
    override fun postLogin(postLoginRequest: PostLoginRequest, callback: Subscriber<PostLoginResponse>) {
        CatService.getCatService()
                .postLogin(postLoginRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback)
    }

    override fun getSingleCat(id: String, callback: Subscriber<GetSingleCatResponse>) {
        CatService.getCatService()
                .getSingleCat(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback)
    }

    override fun getNearbyCat(callback: Subscriber<GatNearbyCatResponse>) {
        CatService.getCatService()
                .getNearbyCat()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback)
    }

}