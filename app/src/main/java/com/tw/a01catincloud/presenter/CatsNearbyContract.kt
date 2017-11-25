package com.tw.a01catincloud.presenter

import com.tw.a01catincloud.model.GatNearbyCatResponse

/**
 * Created by xxzeng on 09/11/2017.
 */

interface CatsNearbyContract {
    interface View {
        fun showNearbyCats(catsNearby: List<CatsNearby>)

        fun onGetDataFail(msg: String)
        fun onGetDataSucceed(data: List<GatNearbyCatResponse.MomentsBean>)
    }
    interface Presenter {
        fun start()
        fun stop()
    }
}