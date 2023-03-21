package com.siddroid.stocks.core

import java.net.InetSocketAddress
import java.net.Socket

/** This class is to ping the internet connection of the connected network  **/

object InternetAvailability {

    fun check():Boolean{
        return try {
            val socket = Socket()
            socket.connect(InetSocketAddress("8.8.8.8",53))
            socket.close()
            true
        } catch ( e: java.lang.Exception){
            false
        }

    }
}