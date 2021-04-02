package com.project.lab1.feed.adapters


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.databinding.FeedCellLayoutBinding
//import com.project.lab1.databinding.ActivitySeeNotesBinding
import com.project.lab1.feed.ImagePost
import com.project.lab1.feed.models.FeedItem
import com.project.lab1.feed.viewHolders.FeedItemViewHolder
import kotlinx.android.synthetic.main.feed_cell_layout.view.*


class FeedRecyclerViewAdapter(private val dataSet: Array<FeedItem>) : RecyclerView.Adapter<FeedItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedItemViewHolder {
        val binding = FeedCellLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FeedItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: FeedItemViewHolder, position: Int) {
        holder.bind(dataSet[position])
        holder.itemView.setOnClickListener { item -> onClick(item) }
    }

    override fun getItemCount() = dataSet.size

    fun onClick(view: View) {
        val id = view.headerTextView.text
        val intent = Intent(view.context, ImagePost::class.java)
        intent.putExtra("id", id);
        view.context.startActivity(intent)
    }
}
