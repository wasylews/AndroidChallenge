package com.genius.wasylews.exhibitviewer.pager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.genius.wasylews.model.Exhibit

class ImagePagerAdapter(private val item: Exhibit,
                        fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = ImageFragment.newInstance(item.title, item.images[position])

    override fun getCount(): Int = item.images.size
}