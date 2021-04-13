package com.project.lab1.presentation.feedImage

import com.project.lab1.presentation.feedImage.models.FeedImage


interface ImageInput {
    fun updateUI(data: FeedImage)
}

interface ImageOutput {
    fun getImage(token: String, id: String)

    fun addNote(token: String, id: String)
}
