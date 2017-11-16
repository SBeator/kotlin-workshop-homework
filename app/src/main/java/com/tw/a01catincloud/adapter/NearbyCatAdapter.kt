package com.tw.a01catincloud.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.tw.a01catincloud.R
import com.tw.a01catincloud.presenter.CatsNearby
import com.tw.a01catincloud.utils.HttpUtils

/**
 * Created by xxzeng on 02/11/2017.
 */
class NearbyCatAdapter(val context: Context, val data: List<CatsNearby>) : BaseAdapter(){
    val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        if (convertView == null) {
            view = inflater.inflate(R.layout.nearby_cat_list_item, null, false)
        } else {
            view = convertView
        }

        var profile = R.mipmap.profile1
        if (position % 2 != 0) {
            profile = R.mipmap.profile2
        }

        var cat = data[position]

//        var image = HttpUtils().doDownloadImage("http://10.0.2.2:8080/catnip" + cat.avatar.imageUrl)

        view.findViewById<ImageView>(R.id.profile).setImageResource(profile)
//        view.findViewById<ImageView>(R.id.profile).setImageBitmap(image)
        view.findViewById<TextView>(R.id.catowner).text = cat.name
        view.findViewById<TextView>(R.id.description).text = cat.description
        view.findViewById<TextView>(R.id.time).text = cat.updateTime.toString()

        return view
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }
}