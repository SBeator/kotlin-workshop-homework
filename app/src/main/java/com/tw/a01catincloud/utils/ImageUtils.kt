package com.tw.a01catincloud.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.tw.a01catincloud.R

/**
 * Created by xxzeng on 06/12/2017.
 */

class ImageUtils {
    val baseUrl = "http://10.0.2.2:8080/catnip/"

    fun showImage(context: Context, imageRelativeUrl: String, imageView: ImageView) {
        Glide.with(context).load(baseUrl + imageRelativeUrl).into(imageView)
    }
}