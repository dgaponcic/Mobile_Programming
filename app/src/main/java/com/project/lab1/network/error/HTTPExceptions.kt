package com.project.lab1.network.error


import com.sample.app.data.network.error.ApiError
import java.io.IOException

sealed class HttpException(apiError: ApiError) : IOException(apiError.error)

class BadRequestException(apiError: ApiError) : HttpException(apiError)
class UnauthorizedAccessException(apiError: ApiError) : HttpException(apiError)
