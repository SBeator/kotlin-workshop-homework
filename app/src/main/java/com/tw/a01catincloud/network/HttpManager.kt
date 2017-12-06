package com.tw.a01catincloud.network

import com.tw.a01catincloud.model.GatNearbyCatResponse
import com.tw.a01catincloud.model.GetSingleCatResponse
import rx.Subscriber

/**
 * Created by xxzeng on 16/11/2017.
 */

interface HttpManager {
    fun getNearbyCat(callback: Subscriber<GatNearbyCatResponse>)
    fun getSingleCat(id: String, callback: Subscriber<GetSingleCatResponse>)
}