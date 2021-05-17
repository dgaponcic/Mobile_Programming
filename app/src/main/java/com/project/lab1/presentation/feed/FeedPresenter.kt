package com.project.lab1.presentation.feed

import com.project.lab1.presentation.feed.models.FeedItem
import com.project.lab1.network.models.Image
import com.project.lab1.presentation.APIClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class FeedPresenter(val view: FeedInput, val apiService: APIClient): FeedOutput {
    override fun getPastImages(token: String) {
        GlobalScope.launch {
            kotlin.runCatching {
                apiService.getPastImages(token)
            }.onSuccess {
                handleAPIData(it)
            }.onFailure {
                handleAPIDataError(it)
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
            view.updateUI(posts)
        }
    }

    private fun handleAPIDataError(error: Throwable) {
        MainScope().launch {
            view.showErrorAlert("An error occurred.")
        }
    }
}
