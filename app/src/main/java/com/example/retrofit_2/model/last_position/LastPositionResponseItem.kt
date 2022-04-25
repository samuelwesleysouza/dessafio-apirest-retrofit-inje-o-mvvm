package com.example.retrofit_2.model.last_position

data class LastPositionResponseItem(
    val darkIcon: String,
    val dateLastCheckpoint: String,
    val descriptionLastCheckpoint: String,
    val direction: String,
    val driverName: String,
    val event: String,
    val eventDate: String,
    val formatAddress: String,
    val geographyDistance: String,
    val idPosition: Int,
    val latitude: String,
    val longitude: String,
    val pinIcon: String,
    val priorityRuleColor: String,
    val priorityRuleName: String,
    val status: Status,
    val trackedUnityId: Int,
    val trackedUnityName: String,
    val trackedUnityTypeId: Int,
    val trackerId: Int,
    val trackerOrder: Int,
    val updateDate: String,
    val velocity: Int
)