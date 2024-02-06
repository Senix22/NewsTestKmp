package com.example.newstestkmp

import platform.UIKit.UIDevice

actual class DeviceInfo {
    actual val osName: String
        get() = UIDevice.currentDevice.systemName
    actual val osVersion: String
        get() = UIDevice.currentDevice.systemVersion
    actual val osDeviceModel: String
        get() = UIDevice.currentDevice.model

    actual fun logIt() {
    }
}