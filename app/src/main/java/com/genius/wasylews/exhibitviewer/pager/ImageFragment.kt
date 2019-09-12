package com.genius.wasylews.exhibitviewer.pager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.genius.wasylews.exhibitviewer.R
import kotlinx.android.synthetic.main.fragment_image.*

class ImageFragment: Fragment() {

    companion object {

        private const val ARG_ITEM_NAME = "exhibit_item_name"
        private const val ARG_ITEM_IMAGE_URL = "exhibit_item_image_url"

        fun newInstance(name: String, imageUrl: String): Fragment {
            val args = Bundle()
            args.putString(ARG_ITEM_NAME, name)
            args.putString(ARG_ITEM_IMAGE_URL, imageUrl)

            val fragment = ImageFragment()
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        loadData(arguments?.getString(ARG_ITEM_NAME),
            arguments?.getString(ARG_ITEM_IMAGE_URL))
    }

    private fun loadData(name: String?, url: String?) {
        text_name.text = name
        Glide.with(image)
            .load(url)
            .fallback(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(image)
    }
}