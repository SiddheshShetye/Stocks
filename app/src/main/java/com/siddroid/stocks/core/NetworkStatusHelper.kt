package com.siddroid.stocks.core

import android.net.*
import androidx.lifecycle.LiveData

/** This an injectable class is a helper class to check the connectivity state of the app for internet which can be observed **/

class NetworkStatusHelper(private val connectivityManager: ConnectivityManager) :
    LiveData<NetworkStatusHelper.NetworkState>() {

    private lateinit var connectivityManagerCallback: ConnectivityManager.NetworkCallback
    private var isInternetConnected: Boolean = false

    override fun onActive() {
        super.onActive()
        connectivityManagerCallback = getConnectivityManagerCallback()
        val networkRequest = NetworkRequest
            .Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()
        connectivityManager.registerNetworkCallback(networkRequest, connectivityManagerCallback)
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(connectivityManagerCallback)
    }

    private fun getConnectivityManagerCallback() =
        object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                setInternetState(false)
            }

            override fun onLinkPropertiesChanged(network: Network, linkProperties: LinkProperties) {
            }

            override fun onLosing(network: Network, maxMsToLive: Int) {
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                super.onCapabilitiesChanged(network, networkCapabilities)
                val isInternet =
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                val isValidated =
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)

                if (isInternet && isValidated) {
                    if (InternetAvailability.check()) {
                        setInternetState(true)
                    }
                }
            }
        }

    fun getInternetState(): NetworkState {
        return if (isInternetConnected) {
            NetworkState.INTERNET_CONNECTED
        } else {
            NetworkState.INTERNET_DISCONNECTED
        }
    }

    private fun setInternetState(boolean: Boolean) {
        isInternetConnected = boolean
        if (isInternetConnected) {
            postValue(NetworkState.INTERNET_CONNECTED)
        } else {
            postValue(NetworkState.INTERNET_DISCONNECTED)
        }


    }

    enum class NetworkState {
        INTERNET_CONNECTED, INTERNET_DISCONNECTED
    }
}