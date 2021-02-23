package com.project.lab1.feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.R
import com.project.lab1.feed.adapters.FeedRecyclerViewAdapter
import com.project.lab1.feed.models.FeedItem

class FeedActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        // Create Recycler view layout manager, for simple lists use Linear layout
        viewManager = LinearLayoutManager(this)

        // Create sample data set of 30 dummy elements
        viewAdapter = FeedRecyclerViewAdapter(Array(30) {
            FeedItem(
                "My f header",
                "Some description",
                "https://images.unsplash.com/photo-1505673542670-a5e3ff5b14a3?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
            )
        })

        // Find recycler view in hierarchy of elements and set layout manager and adapter
        recyclerView = findViewById<RecyclerView>(R.id.feed_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
    }
}