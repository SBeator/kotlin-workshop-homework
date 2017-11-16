package com.tw.a01catincloud.presenter

/**
 * Created by xxzeng on 23/10/2017.
 */


interface LoginContract {
    interface Presenter {
        fun startLogin(userName: String, password: String)
    }

    interface View {
        fun loginSuccess()
    }
}