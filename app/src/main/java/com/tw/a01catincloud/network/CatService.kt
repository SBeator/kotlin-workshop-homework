package com.tw.a01catincloud.network

import com.tw.a01catincloud.model.GatNearbyCatResponse
import com.tw.a01catincloud.model.GetSingleCatResponse
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by xxzeng on 16/11/2017.
 */

interface CatService {
    @GET("catnip/moment/")
    fun getNearbyCat(): Observable<GatNearbyCatResponse>

    @GET("catnip/moment/{id}")
    fun getSingleCat(@Path("id") id: String): Observable<GetSingleCatResponse>

    companion object {
        fun getCatService(): CatService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://10.0.2.2:8080")
                    .build()

            return retrofit.create(CatService::class.java)
        }
    }
}