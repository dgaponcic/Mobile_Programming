package com.project.lab1.feed.adapters

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.R
import com.project.lab1.databinding.FeedCellLayoutBinding
import com.project.lab1.feed.models.FeedItem
import com.project.lab1.feed.viewHolders.FeedItemViewHolder


class FeedRecyclerViewAdapter(private val dataSet: Array<FeedItem>) : RecyclerView.Adapter<FeedItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedItemViewHolder {
        // Inflate view binding for feed cell
        val binding = FeedCellLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return FeedItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedItemViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size
}
