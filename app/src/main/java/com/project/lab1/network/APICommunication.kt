package com.project.lab1.network;

import com.project.lab1.network.error.HttpErrorInterceptor
import com.project.lab1.network.models.*
import com.project.lab1.presentation.APIClient
import com.sample.app.data.network.error.ApiError
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import retrofit2.converter.gson.GsonConverterFactory

private const val READ_TIMEOUT: Long = 3000
private const val WRITE_TIMEOUT: Long = 3000
private const val CONNECTION_TIMEOUT: Long = 3000


class APICommunication(): APIClient {
    private val client = buildClient()

    private var retrofit = Retrofit.Builder()
            .baseUrl("https://2df6c39fdbdf.ngrok.io")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    private val apiService = retrofit.create(APIService::class.java)

    private fun buildClient(): OkHttpClient {
        val errorInterceptor = HttpErrorInterceptor {
            retrofit.responseBodyConverter(ApiError::class.java, emptyArray())
        }

        return OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
                .connectionPool(ConnectionPool(20, 5, TimeUnit.MINUTES))
                .addInterceptor(errorInterceptor)
                .build()
    }

    override suspend fun getPastImages(token: String): ArrayList<Image> {
        return apiService.getPastImages("JWT ${token}")
    }

    override suspend fun getImage(token: String, id: String): Image {
        return apiService.getImage("JWT ${token}", id)
    }

    override suspend fun auth(username: String, password: String): AuthToken {
        val body = LoginBody(username, password)
        return apiService.auth(body)
    }

    override suspend fun addNote(token: String, link: String) {
        val body = Note(link)
        return apiService.addNote("JWT ${token}", body)
    }

    override suspend fun getNotes(token: String): ArrayList<Note> {
        return apiService.getNotes("JWT ${token}")
    }
}
