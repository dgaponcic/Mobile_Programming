package com.project.lab1.presentation.feed

import com.project.lab1.presentation.feed.models.FeedItem

interface FeedInput {
    fun updateUI(data: Array<FeedItem>)
    fun showErrorAlert(message: String)
}

interface FeedOutput {
    fun getPastImages(token: String)
}
