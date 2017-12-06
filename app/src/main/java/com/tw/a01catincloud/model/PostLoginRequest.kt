package com.tw.a01catincloud.model

/**
 * Created by xxzeng on 06/12/2017.
 */
class PostLoginRequest {

    constructor(username: String?, password: String?) {
        this.username = username
        this.password = password
    }

    var username: String? = null
    var password: String? = null

}