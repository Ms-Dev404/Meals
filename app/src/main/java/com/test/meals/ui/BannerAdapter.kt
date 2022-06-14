package com.test.meals.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import coil.load
import com.test.meals.databinding.BannerLayoutBinding
import com.test.meals.model.Banner
import java.util.*
import kotlin.collections.ArrayList


class BannerAdapter():PagerAdapter() {

   private var _bannerList=ArrayList<Banner>()

    override fun getCount()=_bannerList.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

       return true
    }

    fun setData(bannerList:ArrayList<Banner>){

       _bannerList = bannerList;
        notifyDataSetChanged()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val binding =BannerLayoutBinding.inflate(LayoutInflater.from(container.context),container,false)
        binding.ivImage.load(_bannerList[position].imageUl)
        Objects.requireNonNull(container).addView(binding.root)
        return binding.root
    }


}