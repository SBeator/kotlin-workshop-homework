package com.tw.a01catincloud.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.tw.a01catincloud.R
import com.tw.a01catincloud.presenter.LoginContract
import com.tw.a01catincloud.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), LoginContract.View{
    private val TAG: String = "LoginActivity"
    private lateinit var mBtnLogin: Button
    private lateinit var mEditUsername: EditText
    private lateinit var mEditPassword: EditText

    private val presenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Log.d(TAG, "onCreate")

        mBtnLogin = findViewById(R.id.button_login) as Button
        mEditUsername = findViewById(R.id.username) as EditText
        mEditPassword = findViewById(R.id.password) as EditText

        mBtnLogin.setOnClickListener {
            var username = mEditUsername.text.toString()
            var password = mEditPassword.text.toString()

//            Log.i("cat", "Button clicked!" + username +  "," + password)
            presenter.startLogin(username, password);
        }
    }

    override fun loginSuccess() {
        Log.d(TAG, "login success")
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}
