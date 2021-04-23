package com.project.lab1.presentation.feed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.databinding.ActivityFeedBinding
import com.project.lab1.presentation.feed.adapters.FeedRecyclerViewAdapter
import com.project.lab1.presentation.feed.models.FeedItem
import com.project.lab1.presentation.notes.NotesActivity
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class FeedActivity : FeedInput, AppCompatActivity() {

    private lateinit var binding: ActivityFeedBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val presenter: FeedOutput by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val seeNotes: Button = binding.seeNotes
        seeNotes.setOnClickListener {
            startActivity(Intent(this, NotesActivity::class.java))
        }

        viewManager = LinearLayoutManager(this)
        val pref = getSharedPreferences("tokens", MODE_PRIVATE)
        val token = pref.getString("auth", "")

        if (token != null) {
            presenter.getPastImages(token)
        }
    }

    override fun updateUI(posts: Array<FeedItem>) {
        MainScope().launch {
            viewAdapter = FeedRecyclerViewAdapter(posts)

            recyclerView = binding.feedRecyclerView.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        }
    }
}
