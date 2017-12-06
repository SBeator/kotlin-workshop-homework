package com.tw.a01catincloud.presenter

import android.text.TextUtils
import android.util.Log
import com.tw.a01catincloud.model.GetSingleCatResponse
import com.tw.a01catincloud.model.PostLoginRequest
import com.tw.a01catincloud.model.PostLoginResponse
import com.tw.a01catincloud.network.HttpsManagerFactory
import rx.Subscriber

/**
 * Created by xxzeng on 23/10/2017.
 */

class LoginPresenter(private val loginView: LoginContract.View): LoginContract.Presenter {

    private val TAG: String = "LoginPresenter"

    override fun startLogin(userName: String, password: String) {
        Log.d(TAG, "Usernaem: $userName, Password: $password")
        validateAccount(userName, password)
    }

    private fun validateAccount(userName: String, password: String) {

        val postLoginRequestBody = PostLoginRequest(userName, password)

        HttpsManagerFactory.getMeetingHttpManager().postLogin(postLoginRequestBody, object: Subscriber<PostLoginResponse>() {
            override fun onNext(response: PostLoginResponse?) {
                if (response != null) {
                    if (response.key != null && !response.key.equals("")) {
                        loginView.loginSuccess(response.key!!)
                        return
                    }
                }

                loginView.loginFailure(response?.message)
            }

            override fun onCompleted() {

            }

            override fun onError(e: Throwable?) {
                loginView.loginFailure(e?.message)
            }
        })
    }
}