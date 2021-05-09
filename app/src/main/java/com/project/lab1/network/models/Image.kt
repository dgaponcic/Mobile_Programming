package com.project.lab1.network.models

class Image (
    val id: String,
    val width: Int,
    val height: Int,
    val color: String,
    val alt_description: String?,
    val links: Links,
    val likes: Int,
    val urls: URLS,
    val user: User
)
