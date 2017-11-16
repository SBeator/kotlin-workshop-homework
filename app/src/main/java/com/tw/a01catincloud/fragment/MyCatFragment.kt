package com.tw.a01catincloud.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tw.a01catincloud.R

/**
 * Created by xxzeng on 02/11/2017.
 */

class MyCatFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_my_cat, container, false)
    }
}