package com.tw.a01catincloud.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.tw.a01catincloud.R
import com.tw.a01catincloud.activity.HomeActivity
import com.tw.a01catincloud.activity.SingleCatActivity
import com.tw.a01catincloud.adapter.NearbyCatAdapter
import com.tw.a01catincloud.model.GatNearbyCatResponse
import com.tw.a01catincloud.presenter.CatsNearby
import com.tw.a01catincloud.presenter.CatsNearbyContract
import com.tw.a01catincloud.presenter.CatsNearbyPresenter

/**
 * Created by xxzeng on 02/11/2017.
 */

class NearbyCatFragment : Fragment(), CatsNearbyContract.View, AdapterView.OnItemClickListener {
    private var TAG = "NearbyCatFragment"
    private lateinit var mListView: ListView
    private lateinit var mPresenter: CatsNearbyContract.Presenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_nearby_cat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mListView = view.findViewById(R.id.listview)

        setupCarousel()
    }

    private fun setupCarousel() {
//        mPresenter = CatsNearbyPresenter(this)
//        mPresenter.start()
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//        Toast.makeText(activity, "item clicked", Toast.LENGTH_SHORT).show()

        var intent = Intent(context, SingleCatActivity::class.java)
        intent.putExtra(SingleCatActivity.CAT_ID_STRING, "cat1")
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
    }

    override fun showNearbyCats(catsNearby: List<CatsNearby>) {
//        mListView.adapter = NearbyCatAdapter(activity, catsNearby)
//        mListView.onItemClickListener = this
    }

    override fun onResume() {
        super.onResume()
        mPresenter = CatsNearbyPresenter(this)
        mPresenter.start()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.stop()
    }


    override fun onGetDataFail(msg: String) {
        Toast.makeText(context, "get data failed!\n" + msg, Toast.LENGTH_SHORT).show()
    }

    override fun onGetDataSucceed(catsNearby: List<GatNearbyCatResponse.MomentsBean>) {
//        Toast.makeText(context, "get data success!", Toast.LENGTH_SHORT).show()

        mListView.adapter = NearbyCatAdapter(activity, catsNearby)
        mListView.onItemClickListener = this
    }
}