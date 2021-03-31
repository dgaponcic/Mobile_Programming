package com.project.lab1.network

import com.project.lab1.network.models.Image
import com.project.lab1.network.models.Launch
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
//    @GET("launches/past")
//    suspend fun getPastLaunches(): ArrayList<Launch>

    @GET("photos?client_id=8zPmZv_H6-lGzuPd-AODt41eFcINcaDxa9emLLYQHXo")
    suspend fun getPastImages(): ArrayList<Image>

    @GET("photos/{id}?client_id=8zPmZv_H6-lGzuPd-AODt41eFcINcaDxa9emLLYQHXo")
    suspend fun getImage(@Path(value = "id") id: String): Image

//    https://unsplash.com/oauth/authorize?client_id=8zPmZv_H6-lGzuPd-AODt41eFcINcaDxa9emLLYQHXo&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&scope=public+read_user
    @GET("oauth/authorize?client_id=8zPmZv_H6-lGzuPd-AODt41eFcINcaDxa9emLLYQHXo&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&scope=public+read_user")
    suspend fun auth()
}
