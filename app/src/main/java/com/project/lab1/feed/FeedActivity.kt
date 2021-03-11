package com.project.lab1.feed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.databinding.ActivityFeedBinding
import com.project.lab1.feed.adapters.FeedRecyclerViewAdapter
import com.project.lab1.feed.models.FeedItem

class FeedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFeedBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var posts = intent.getSerializableExtra("posts") as Array<FeedItem>

        val addPostButton: Button = binding.addPostButton
        addPostButton.setOnClickListener {
            val intent = Intent(this, AddPost::class.java)
            intent.putExtra("posts", posts);
            startActivity(intent)
        }

        viewManager = LinearLayoutManager(this)
        viewAdapter = FeedRecyclerViewAdapter(posts)

        recyclerView = binding.feedRecyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}