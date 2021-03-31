package com.project.lab1.feed

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.project.lab1.R
import com.project.lab1.databinding.ActivityImagePostBinding
import com.project.lab1.feed.adapters.FeedRecyclerViewAdapter
import com.project.lab1.feed.extensions.fadeIn
import com.project.lab1.feed.extensions.fadeOut
import com.project.lab1.feed.models.FeedItem
import com.project.lab1.network.APICommunication
import com.project.lab1.network.models.Image
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class ImagePost : AppCompatActivity() {

    private lateinit var binding: ActivityImagePostBinding
    private lateinit var apiService: APICommunication



    private fun getImage(id: String) {
        showProgress()
        MainScope().launch {
            kotlin.runCatching {
                apiService.getImage(id)
            }.onSuccess {
                handleAPIData(it)
            }.onFailure {
                Log.d("lala2", it.toString())
                print(it)
                MainScope().launch { hideProgress() }
            }
        }
    }

    private fun handleAPIData(data: Image) {
//        val posts = data.map { FeedItem(
//            it.id,
//            it.alt_description,
//            it.urls.small)
//        }.toTypedArray()
//        Log.d("lll", posts.toString())
//        MainScope().launch {
//            hideProgress()
//            viewAdapter = FeedRecyclerViewAdapter(posts)
//
//            recyclerView = binding.feedRecyclerView.apply {
//                layoutManager = viewManager
//                adapter = viewAdapter
//            }
//        }

        hideProgress()
        binding.imageId.text = data.id
        binding.imageDescription.text = data.alt_description
        Picasso.get()
            .load(data.urls.small)
            .error(R.drawable.placeholder)
            .fit()
            .into(binding.imagePostView)
        this.setVisible(true)

    }

    private fun hideProgress() {
        binding.progressOverlay.root.fadeOut()
    }

    private fun showProgress() {
        binding.progressOverlay.root.fadeIn()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImagePostBinding.inflate(layoutInflater)
        this.setVisible(false)
        setContentView(binding.root)
        val id = intent.getSerializableExtra("id") as String
        apiService = APICommunication()
        getImage(id)
    }
}
