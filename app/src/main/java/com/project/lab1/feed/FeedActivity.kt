package com.project.lab1.feed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.R
import com.project.lab1.feed.adapters.FeedRecyclerViewAdapter
import com.project.lab1.feed.models.FeedItem
import kotlinx.android.synthetic.main.activity_main.*

class FeedActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        var posts = intent.getSerializableExtra("posts") as Array<FeedItem>

        val addPostButton: Button = findViewById(R.id.addPostButton)

        addPostButton.setOnClickListener {
            val intent = Intent(this, AddPost::class.java)
            intent.putExtra("posts", posts);
            startActivity(intent)
        }

        viewManager = LinearLayoutManager(this)
        viewAdapter = FeedRecyclerViewAdapter(posts)

        recyclerView = findViewById<RecyclerView>(R.id.feed_recycler_view).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}