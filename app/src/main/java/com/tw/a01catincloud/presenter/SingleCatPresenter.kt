package com.tw.a01catincloud.presenter

import com.tw.a01catincloud.model.GetSingleCatResponse
import com.tw.a01catincloud.network.HttpsManagerFactory
import rx.Subscriber

/**
 * Created by xxzeng on 06/12/2017.
 */
class SingleCatPresenter(val mSingleCatView: SingleCatContract.View): SingleCatContract.Presenter {
    override fun start(id: String) {
        HttpsManagerFactory.getMeetingHttpManager().getSingleCat(id, object: Subscriber<GetSingleCatResponse>() {
            override fun onNext(response: GetSingleCatResponse?) {
                mSingleCatView.onGetDataSucceed(response!!)
            }

            override fun onCompleted() {

            }

            override fun onError(e: Throwable?) {
                mSingleCatView.onGetDataFail(e.toString())
            }
        })
    }

    override fun stop() {
    }
}