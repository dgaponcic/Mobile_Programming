package com.project.lab1.presentation.feed.models

import java.io.Serializable

class FeedItem(val postAuthor: String, val postDescription: String?, val postImage: String) :Serializable {
    override fun toString(): String {
        return "{postAuthor:" + postAuthor + ", postDescription:" + postDescription + ", postImage:" + postImage + "}"
    }
}
