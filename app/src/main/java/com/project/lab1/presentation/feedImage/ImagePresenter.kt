package com.project.lab1.presentation.feedImage

import com.project.lab1.network.models.Image
import com.project.lab1.presentation.feedImage.models.FeedImage
import com.project.lab1.presentation.APIClient
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class ImagePresenter(val view: ImageInput, val apiService: APIClient): ImageOutput {
    override fun getImage(token: String, id: String) {
        MainScope().launch {
            kotlin.runCatching {
                apiService.getImage(token, id)
            }.onSuccess {
                handleAPIData(it)
            }.onFailure {
                handleAPIDataError(it)
                print(it)
            }
        }
    }


    override fun addNote(token: String, link: String) {
        MainScope().launch {
            kotlin.runCatching {
                apiService.addNote(token, link)
            }.onSuccess {
                handleNoteAdded()
            }.onFailure {
                handleAPIDataError(it)
                print(it)
            }
        }
    }

    private fun handleNoteAdded() {
        MainScope().launch {
            view.showNoteAdded()
        }
    }

    private fun handleAPIData(data: Image) {
        val image = FeedImage(data.id, data.alt_description, data.urls.small, data.user.username)

        MainScope().launch {
            view.updateUI(image)
        }
    }

    private fun handleAPIDataError(error: Throwable) {
        MainScope().launch {
            view.showErrorAlert("An error occurred.")
        }
    }
}
