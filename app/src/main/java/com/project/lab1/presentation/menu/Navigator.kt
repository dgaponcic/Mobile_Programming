package com.project.lab1.presentation.menu

import android.content.Context
import android.content.Intent
import com.project.lab1.presentation.feed.FeedActivity

class Navigator(private val context: Context) {

    fun openFeed() {
        context.startActivity(Intent(context, FeedActivity::class.java))
    }
}
