package com.tw.a01catincloud.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.tw.a01catincloud.R
import com.tw.a01catincloud.model.GetSingleCatResponse
import com.tw.a01catincloud.presenter.CatsNearbyPresenter
import com.tw.a01catincloud.presenter.SingleCatContract
import com.tw.a01catincloud.presenter.SingleCatPresenter
import com.tw.a01catincloud.utils.ImageUtils

/**
 * Created by xxzeng on 06/12/2017.
 */
class SingleCatActivity: AppCompatActivity(), SingleCatContract.View {
    companion object {
        val CAT_ID_STRING = "cat_id_string"
    }

    var imageUtils = ImageUtils()

    lateinit var mPresenter: SingleCatContract.Presenter
    var catId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_cat)

        catId = intent?.getStringExtra(CAT_ID_STRING)
    }

    override fun onResume() {
        super.onResume()
        mPresenter = SingleCatPresenter(this)

        if (catId != null) {
            mPresenter.start(catId!!)
        }
    }

    override fun onGetDataFail(msg: String) {
        Toast.makeText(this, "get data failed!\n" + msg, Toast.LENGTH_SHORT).show()
    }

    override fun onGetDataSucceed(data: GetSingleCatResponse) {
//        Toast.makeText(this, "get data success!", Toast.LENGTH_SHORT).show()

        imageUtils.showImage(this, data.banner!!.image!!, this.findViewById(R.id.image_banner))
        imageUtils.showImage(this, data.avatar!!.image!!, this.findViewById(R.id.avatar))

        this.findViewById<TextView>(R.id.message).text = data.message
        this.findViewById<TextView>(R.id.description).text = data.age.toString() + " years old | " + data.kind
        this.findViewById<TextView>(R.id.star).text = data.stars.toString() + " Stars"
        this.findViewById<TextView>(R.id.follows).text = data.follows.toString() + " Follows"
        this.findViewById<TextView>(R.id.fishes).text = data.fishes.toString() + " Fishes"
        this.findViewById<TextView>(R.id.adopted).text = data.adopted.toString() + " Adopted"


    }
}