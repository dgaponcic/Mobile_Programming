package com.project.lab1.network;

import com.project.lab1.network.error.HttpErrorInterceptor
import com.project.lab1.network.models.Image
import com.sample.app.data.network.error.ApiError
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import retrofit2.converter.gson.GsonConverterFactory

private const val READ_TIMEOUT: Long = 3000
private const val WRITE_TIMEOUT: Long = 3000
private const val CONNECTION_TIMEOUT: Long = 3000


class APICommunication {
    private val client = buildClient()

    private var retrofit = Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
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

//    suspend fun getPastLaunches(): ArrayList<Launch> {
//        return apiService.getPastLaunches()
//    }

    suspend fun getPastImages(): ArrayList<Image> {
        return apiService.getPastImages()
    }

    suspend fun getImage(id: String): Image {
        return apiService.getImage(id)
    }

    suspend fun auth() {

    }
}