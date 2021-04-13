package com.project.lab1.presentation.feed.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.R
import com.project.lab1.databinding.FeedCellLayoutBinding
import com.project.lab1.presentation.feed.models.FeedItem
import com.squareup.picasso.Picasso

class FeedItemViewHolder(private val binding: FeedCellLayoutBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: FeedItem) {
        binding.headerTextView.text = item.postAuthor
        binding.descriptionTextView.text = item.postDescription
        Picasso.get()
            .load(item.postImage)
            .error(R.drawable.placeholder)
            .fit()
            .into(binding.imageView)
    }
}
