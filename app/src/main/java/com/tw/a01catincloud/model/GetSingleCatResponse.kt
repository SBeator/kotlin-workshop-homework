package com.tw.a01catincloud.model

/**
 * Created by xxzeng on 06/12/2017.
 */
class GetSingleCatResponse {
    var cat: String? = null
    var message: String? = null
    var banner: ImageBean? = null
    var avatar: ImageBean? = null
    var age: Int? = null
    var kind: String? = null
    var stars: Int? = null
    var follows: Int? = null
    var fishes: Int? = null
    var adopted: Int? = null

    class ImageBean {
        var image: String? = null
    }
}