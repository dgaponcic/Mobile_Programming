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
import com.project.lab1.network.APICommunication
import com.project.lab1.network.models.Image
import com.project.lab1.notes.NotesActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class FeedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var apiService: APICommunication

    private fun getPastImages(token: String) {
        GlobalScope.launch {
            kotlin.runCatching {
                apiService.getPastImages(token)
            }.onSuccess {
                handleAPIData(it)
            }.onFailure {
                print(it)
            }
        }
    }

    private fun handleAPIData(data: ArrayList<Image>) {
        val posts = data.map { FeedItem(
            it.id,
            it.alt_description,
            it.urls.small)
        }.toTypedArray()

        MainScope().launch {
            viewAdapter = FeedRecyclerViewAdapter(posts)

            recyclerView = binding.feedRecyclerView.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val seeNotes: Button = binding.seeNotes
        seeNotes.setOnClickListener {
            startActivity(Intent(this, NotesActivity::class.java))
        }

        viewManager = LinearLayoutManager(this)
        apiService = APICommunication()

        val pref = getSharedPreferences("tokens", MODE_PRIVATE)
        val token = pref.getString("auth", "")

        if (token != null) {
            getPastImages(token)
        }
    }
}
