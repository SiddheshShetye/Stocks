package com.siddroid.stocks.core

import java.util.*

sealed interface Response<T : Any>
    class Success<T: Any>(val data: T) : Response<T>
    class Failure<T: Any>(val code: Int, val message: String?) : Response<T>
    class Exception<T: Any>(val e: Throwable) : Response<T>
