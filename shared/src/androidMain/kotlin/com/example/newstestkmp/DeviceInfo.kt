package com.example.newstestkmp

import android.os.Build

actual class DeviceInfo {
    actual val osName: String
        get() = "Android"
    actual val osVersion: String
        get() = Build.VERSION.SDK_INT.toString()
    actual val osDeviceModel: String
        get() = Build.DEVICE

    actual fun logIt() {
    }
}