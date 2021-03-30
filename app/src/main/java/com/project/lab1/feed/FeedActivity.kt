package com.project.lab1.feed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.databinding.ActivityFeedBinding
import com.project.lab1.feed.extensions.fadeIn
import com.project.lab1.feed.extensions.fadeOut
import com.project.lab1.feed.adapters.FeedRecyclerViewAdapter
import com.project.lab1.feed.models.FeedItem
import com.project.lab1.network.APICommunication
import com.project.lab1.network.models.Image
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class FeedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var apiService: APICommunication

    private fun getPastImages() {
        showProgress()

        GlobalScope.launch {
            kotlin.runCatching {
                apiService.getPastImages()
            }.onSuccess {
                Log.d("cmon", "here")
                handleAPIData(it)
            }.onFailure {
                print(it)
                MainScope().launch { hideProgress() }
            }
        }
    }

    private fun handleAPIData(data: ArrayList<Image>) {
        val posts = data.map { FeedItem(
            it.id,
            it.alt_description,
            it.urls.small)
        }.toTypedArray()
        Log.d("lll", posts.toString())
        MainScope().launch {
            hideProgress()
            viewAdapter = FeedRecyclerViewAdapter(posts)

            recyclerView = binding.feedRecyclerView.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        }
    }

    private fun hideProgress() {
        binding.progressOverlay.root.fadeOut()
    }

    private fun showProgress() {
        binding.progressOverlay.root.fadeIn()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val addPostButton: Button = binding.addPostButton
        addPostButton.setOnClickListener {
            startActivity(intent)
        }

        viewManager = LinearLayoutManager(this)
        apiService = APICommunication()
        getPastImages()
    }
}