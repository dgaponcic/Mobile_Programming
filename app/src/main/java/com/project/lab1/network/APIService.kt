package com.project.lab1.network

import com.project.lab1.network.models.Image
import com.project.lab1.network.models.Launch
import retrofit2.http.GET

interface APIService {
//    @GET("launches/past")
//    suspend fun getPastLaunches(): ArrayList<Launch>

    @GET("photos?client_id=8zPmZv_H6-lGzuPd-AODt41eFcINcaDxa9emLLYQHXo")
    suspend fun getPastImages(): ArrayList<Image>
}
