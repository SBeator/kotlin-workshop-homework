package com.tw.a01catincloud.presenter

import com.tw.a01catincloud.model.GetSingleCatResponse

/**
 * Created by xxzeng on 06/12/2017.
 */
interface SingleCatContract {
    interface View {
        fun onGetDataFail(msg: String)
        fun onGetDataSucceed(data: GetSingleCatResponse)
    }
    interface Presenter {
        fun start(id: String)
        fun stop()
    }
}