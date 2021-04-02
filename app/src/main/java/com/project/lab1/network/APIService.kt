package com.project.lab1.network

import com.project.lab1.network.models.*
import retrofit2.http.*


interface APIService {
    @POST("auth")
    suspend fun auth(@Body body: LoginBody): AuthToken

    @GET("images")
    suspend fun getPastImages(@Header("Authorization") token: String): ArrayList<Image>

    @GET("image/{id}")
    suspend fun getImage(@Header("Authorization") token: String, @Path(value = "id") id: String): Image

    @POST("note")
    suspend fun addNote(@Header("Authorization") token: String, @Body body: NoteBody)

    @GET("notes")
    suspend fun getNotes(@Header("Authorization") token: String): NoteResponse
}

