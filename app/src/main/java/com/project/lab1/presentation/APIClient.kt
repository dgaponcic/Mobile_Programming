package com.project.lab1.presentation

import com.project.lab1.network.models.AuthToken
import com.project.lab1.network.models.Image
import com.project.lab1.network.models.Note

interface APIClient {
    suspend fun getImage(token: String, id: String): Image
    suspend fun addNote(token: String, id: String)
    suspend fun getPastImages(token: String): ArrayList<Image>
    suspend fun getNotes(token: String): ArrayList<Note>
    suspend fun auth(username: String, password: String): AuthToken
}
