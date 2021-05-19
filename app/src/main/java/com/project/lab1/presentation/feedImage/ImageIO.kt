package com.project.lab1.presentation.feedImage

import com.project.lab1.presentation.feedImage.models.FeedImage


interface ImageInput {
    fun updateUI(data: FeedImage)
    fun showErrorAlert(message: String)
    fun showNoteAdded()
}

interface ImageOutput {
    fun getImage(token: String, id: String)
    fun addNote(token: String, id: String)
}
