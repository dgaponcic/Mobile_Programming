package com.project.lab1.feed.viewHolders

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.R
import com.project.lab1.databinding.FeedCellLayoutBinding
import com.project.lab1.feed.models.FeedItem
import com.squareup.picasso.Picasso

class FeedItemViewHolder(private val binding: FeedCellLayoutBinding): RecyclerView.ViewHolder(binding.root) {

//    private var view = view
//    val binding = FeedCellLayoutBinding.inflate(LayoutInflater.from(view.context))

//    private var authorTextView: TextView = binding.headerTextView
//    private var descriptionTextView: TextView = binding.descriptionTextView
//    private var imageView: ImageView = binding.imageView
    //    private var authorTextView: TextView = view.findViewById(R.id.headerTextView)
//    private var descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
//    private var imageView: ImageView = view.findViewById(R.id.imageView)

    fun bind(item: FeedItem) {
        Log.d("wfew", item.postDescription)
        binding.headerTextView.text = item.postAuthor
        binding.descriptionTextView.text = item.postDescription
        Picasso.get()
            .load(item.postImage)
            .error(R.drawable.placeholder)
            .fit()
            .into(binding.imageView)
    }
}
