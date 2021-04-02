package com.project.lab1.feed.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.databinding.NoteCellLayoutBinding
import com.project.lab1.feed.models.NoteItem
import com.project.lab1.feed.viewHolders.NoteViewHolder


class NoteAdapter(private val dataSet: Array<NoteItem>) : RecyclerView.Adapter<NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteCellLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size
}
