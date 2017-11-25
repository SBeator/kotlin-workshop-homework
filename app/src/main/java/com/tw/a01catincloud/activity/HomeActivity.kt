package com.tw.a01catincloud.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView

import com.tw.a01catincloud.R
import com.tw.a01catincloud.adapter.BannerAdapter
import com.tw.a01catincloud.fragment.MyCatFragment
import com.tw.a01catincloud.fragment.NearbyCatFragment

class HomeActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {
    private var TAG = "HomeActivity"

    private lateinit var mViewPager: ViewPager
    private lateinit var mIndicator: ViewGroup

    private lateinit var mBtnCatNearby: CheckBox
    private lateinit var mBtnMyCat: CheckBox
    private lateinit var nearbyCatFragment: NearbyCatFragment
    private lateinit var myCatFragment: MyCatFragment
    private lateinit var mTabButtons: ArrayList<CheckBox>
    private lateinit var mTabConentFragments: ArrayList<Fragment>

    private var mPreviousPosition = 0
    private val mImageResIds = arrayListOf<Int>(
            R.mipmap.banner_1,
            R.mipmap.banner_2,
            R.mipmap.banner_3,
            R.mipmap.banner_4)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initBanner()

        setupContent()
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        updateIndicator(position)
        mPreviousPosition = position
    }

    private fun initBanner() {
        mViewPager = findViewById(R.id.viewpager)
        mIndicator = findViewById(R.id.indicator_view)

        var imageList = ArrayList<ImageView>()

        mImageResIds.forEach {
            val iv = ImageView(this)
            iv.scaleType = ImageView.ScaleType.CENTER_CROP
            iv.setImageResource(it)

            imageList.add(iv)
        }

        mViewPager.adapter = BannerAdapter(imageList)
        mViewPager.addOnPageChangeListener(this)
        mPreviousPosition = mViewPager.currentItem

    }

    override fun onResume() {
        super.onResume()

        mHandler.postDelayed(mRunnable, 1000)
    }

    override fun onDestroy() {
        super.onDestroy()
        mHandler.removeCallbacks(mRunnable)
    }

    private var mHandler = Handler()
    private var mRunnable = object: Runnable {
        override fun run() {
            if (mViewPager.currentItem >= mImageResIds.size - 1) {
                mViewPager.currentItem = 0
            } else {
                mViewPager.currentItem = mViewPager.currentItem + 1
            }

            mHandler.postDelayed(this, 1000)
        }
    }

    private fun updateIndicator(position: Int) {
        mIndicator.getChildAt(position)
                .setBackgroundResource(R.drawable.banner_indicator_selected)
        mIndicator.getChildAt(mPreviousPosition)
                .setBackgroundResource(R.drawable.banner_indicator_unselected)
    }

    private fun setupContent() {
        mBtnCatNearby = findViewById(R.id.btn_cat_nearby)
        mBtnMyCat = findViewById(R.id.btn_my_cat)

        nearbyCatFragment = NearbyCatFragment()
        myCatFragment = MyCatFragment()

        mBtnCatNearby.setOnClickListener {
            focusContent(0)
        }

        mBtnMyCat.setOnClickListener {
            focusContent(1)
        }

        mTabButtons = arrayListOf<CheckBox>(
                mBtnCatNearby,
                mBtnMyCat
        )
        mTabConentFragments = arrayListOf<Fragment>(
                nearbyCatFragment,
                myCatFragment
        )

        mTabButtons[0].isChecked = true
        mTabButtons[1].isChecked = false
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, mTabConentFragments[0])
        transaction.commit()
    }

    private fun focusContent(index: Int) {
        mTabButtons.forEach { button ->  button.isChecked = false}
        mTabButtons[index].isChecked = true

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, mTabConentFragments[index])
        transaction.commit()
    }
}


