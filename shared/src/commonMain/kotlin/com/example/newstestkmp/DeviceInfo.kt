package com.example.newstestkmp

expect class DeviceInfo {
    val osName : String
    val osVersion : String
    val osDeviceModel : String

    fun logIt()
}