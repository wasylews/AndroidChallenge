package com.genius.wasylews.exhibitviewer.adapter

import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.genius.wasylews.exhibitviewer.R
import com.genius.wasylews.exhibitviewer.pager.ImagePagerAdapter
import com.genius.wasylews.model.Exhibit
import kotlinx.android.synthetic.main.item_exhibit.view.*

class ExhibitAdapter(private val fm: FragmentManager) : RecyclerView.Adapter<ExhibitAdapter.ExhibitVH>() {

    private var items: List<Exhibit> = emptyList()

    fun setItems(items: List<Exhibit>?) {
        this.items = items!!
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitVH {
        val view = LayoutInflater.from(parent.context)
                                 .inflate(R.layout.item_exhibit, parent, false)
        return ExhibitVH(view, fm)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ExhibitVH, position: Int) = holder.bind(items[position])


    class ExhibitVH(itemView: View, private val fm: FragmentManager) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Exhibit) {
            itemView.pager_image.adapter = ImagePagerAdapter(item, fm)
        }
    }
}