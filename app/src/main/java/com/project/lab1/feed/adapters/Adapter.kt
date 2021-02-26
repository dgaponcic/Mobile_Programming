package com.project.lab1.feed.adapters

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.R
import com.project.lab1.feed.models.FeedItem
import com.project.lab1.feed.viewHolders.FeedItemViewHolder


class FeedRecyclerViewAdapter(private val dataSet: Array<FeedItem>) : RecyclerView.Adapter<FeedItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.feed_cell_layout, parent, false)

        return FeedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedItemViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size
}
