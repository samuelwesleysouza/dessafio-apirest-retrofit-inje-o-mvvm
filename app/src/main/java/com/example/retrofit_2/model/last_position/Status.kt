package com.example.retrofit_2.model.last_position

data class Status(
    val anchor: Anchor,
    val backupBattery: String,
    val backupBatteryMeasurementUnityId: Int,
    val ignition: Boolean,
    val isAvailable: Boolean,
    val isBackupBatteryCharging: Boolean,
    val isBlocked: Boolean,
    val isLBS: Boolean,
    val isOperation: Boolean,
    val validGPS: Boolean
)