package com.tw.a01catincloud.presenter

/**
 * Created by xxzeng on 09/11/2017.
 */

interface CatsNearbyContract {
    interface View {
        fun showNearbyCats(catsNearby: List<CatsNearby>)
    }
    interface Presenter {
        fun start()
        fun stop()
    }
}