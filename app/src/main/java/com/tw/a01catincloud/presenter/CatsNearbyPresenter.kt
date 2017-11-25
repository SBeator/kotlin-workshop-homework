package com.tw.a01catincloud.presenter

import android.os.AsyncTask
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.tw.a01catincloud.model.GatNearbyCatResponse
import com.tw.a01catincloud.network.HttpsManagerFactory
import com.tw.a01catincloud.utils.HttpUtils
import org.json.JSONObject
import rx.Subscriber

/**
 * Created by xxzeng on 09/11/2017.
 */

class CatsNearbyPresenter(private val mCatsNearbyView: CatsNearbyContract.View):
        CatsNearbyContract.Presenter {
    override fun start() {
        HttpsManagerFactory.getMeetingHttpManager().getCat(object: Subscriber<GatNearbyCatResponse>() {
            override fun onNext(response: GatNearbyCatResponse?) {
                mCatsNearbyView.onGetDataSucceed(response!!.moments!!)
            }

            override fun onCompleted() {

            }

            override fun onError(e: Throwable?) {
                mCatsNearbyView.onGetDataFail(e.toString())
            }
        })
    }

    override fun stop() {
    }

//    override fun start() {
//        loaddingCatsNearbyList()
//    }
//
//    private fun loaddingCatsNearbyList() {
//        val catsNearbyTask = CatNearByAsyncTask()
//        catsNearbyTask.execute("http://10.0.2.2:8080/catnip/moment/")
//    }
//
//    override fun stop() {
//    }
//
//    inner class CatNearByAsyncTask: AsyncTask<String, Unit, List<CatsNearby>>() {
//        private val DATE_FORMAT = "yyy-MM-d'T'HH:mm:ss.SSS'Z'"
//
//        override fun doInBackground(vararg params: String?): List<CatsNearby> {
//            val response = HttpUtils().doGet(params[0]!!)
//
//            val gson = GsonBuilder().setDateFormat(DATE_FORMAT).create()
//            return gson.fromJson(JSONObject(response).getString("moments"), object: TypeToken<List<CatsNearby>>(){}.type)
//        }
//
//        override fun onPostExecute(result: List<CatsNearby>) {
//            super.onPostExecute(result)
//
//            mCatsNearbyView.showNearbyCats(result)
//        }
//    }
}