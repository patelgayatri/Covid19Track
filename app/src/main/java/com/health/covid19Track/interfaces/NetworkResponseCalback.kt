package com.health.covid19Track.interfaces

interface NetworkResponseCalback {
    fun onNetworkSuccess()
    fun onNetworkFailure(th : Throwable)
}