package com.siddroid.stocks.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException

abstract class BaseRepo() {

    suspend fun <T : Any> safeApiCall(apiToBeCalled: suspend ( ) -> retrofit2.Response<T>): Response<T> {

        return withContext(Dispatchers.IO) {
            try {

                val response: retrofit2.Response<T> = apiToBeCalled()
                if (response.code() == 200) {
                    response.body()?.let {
                        Success(data = it)
                    } ?: kotlin.run {
                        Failure(response.code(), "No data found")
                    }
                } else {
                    Failure( response.code(), "Something went wrong")
                }

            } catch (e: HttpException) {
                Exception(e)
            } catch (e: IOException) {
                Exception(e)
            } catch (e: java.lang.Exception) {
                Exception(e)
            }
        }
    }
}