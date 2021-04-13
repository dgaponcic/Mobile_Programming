package com.project.lab1.presentation.feed

import com.project.lab1.presentation.feed.models.FeedItem

interface FeedInput {
    fun updateUI(data: Array<FeedItem>)
}

interface FeedOutput {
    fun getPastImages(token: String)
}
