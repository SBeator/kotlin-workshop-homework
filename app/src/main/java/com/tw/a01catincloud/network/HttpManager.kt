package com.tw.a01catincloud.network

import com.tw.a01catincloud.model.GatNearbyCatResponse
import rx.Subscriber

/**
 * Created by xxzeng on 16/11/2017.
 */

interface HttpManager {
    fun getCat(callback: Subscriber<GatNearbyCatResponse>)
}