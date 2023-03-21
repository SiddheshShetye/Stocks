package com.siddroid.stocks.core

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/** An interceptor class that provides authorization token for http client request in header  for retrofit **/

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request: Request = original.newBuilder()
            .method(original.method, original.body)
            .build()
        return chain.proceed(request)
    }

}