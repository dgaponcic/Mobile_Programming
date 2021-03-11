package com.project.lab1.feed.viewHolders

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.R
import com.project.lab1.feed.models.FeedItem
import com.squareup.picasso.Picasso

class FeedItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var view = view
    private var authorTextView: TextView = view.findViewById(R.id.headerTextView)
    private var descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
    private var imageView: ImageView = view.findViewById(R.id.imageView)

    fun bind(item: FeedItem) {
        authorTextView.text = item.postAuthor
        descriptionTextView.text = item.postDescription
        Picasso.get()
            .load(item.postImage)
            .error(R.drawable.placeholder)
            .into(imageView)
    }
}
