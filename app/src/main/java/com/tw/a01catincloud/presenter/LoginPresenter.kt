package com.tw.a01catincloud.presenter

import android.text.TextUtils
import android.util.Log

/**
 * Created by xxzeng on 23/10/2017.
 */

class LoginPresenter(private val loginView: LoginContract.View): LoginContract.Presenter {

    private val TAG: String = "LoginPresenter"

    override fun startLogin(userName: String, password: String) {
        Log.d(TAG, "Usernaem: $userName, Password: $password")
        if (validateAccount(userName, password)) {
            //TODO call login api
            loginView.loginSuccess()
        }
    }

    private fun validateAccount(userName: String, password: String): Boolean {
        return true;


        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            return false
        }

        return true
    }
}