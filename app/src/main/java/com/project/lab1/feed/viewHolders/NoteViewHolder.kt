package com.project.lab1.feed.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.R
//import com.project.lab1.databinding.ActivitySeeNotesBinding
//import com.project.lab1.databinding.FeedCellLayoutBinding
import com.project.lab1.databinding.NoteCellLayoutBinding
//import com.project.lab1.feed.models.FeedItem
import com.project.lab1.feed.models.NoteItem
import com.squareup.picasso.Picasso

class NoteViewHolder(private val binding: NoteCellLayoutBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: NoteItem) {
        Picasso.get()
                .load(item.link)
                .error(R.drawable.placeholder)
                .fit()
                .into(binding.noteImage)
    }
}
