package com.tw.a01catincloud.presenter

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by xxzeng on 09/11/2017.
 */

data class CatsNearby(@SerializedName("id")val id: String,
                      @SerializedName("cat")val name: String,
                      @SerializedName("avatar")val avatar: CatImage,
                      @SerializedName("timestamp")val updateTime: Date,
                      @SerializedName("message")val description: String,
                      @SerializedName("thumbs")val thumbsList: List<CatImage>)