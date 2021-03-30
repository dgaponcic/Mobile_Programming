package com.project.lab1.network.models

import com.google.gson.annotations.SerializedName


class Launch(
    val links: Links,
    @SerializedName("static_fire_date_utc")
    val staticFireDateUTC: String?,
    @SerializedName("static_fire_date_unix")
    val staticFireDateUnix: Double?,
    @SerializedName("rocket")
    val rocketID: String,
    val success: Boolean,
    val details: String?,
    val ships: ArrayList<String>,
    @SerializedName("launchpad")
    val launchpadID: String,
    @SerializedName("flight_number")
    val flightNumber: Int,
    @SerializedName("name")
    val missionName: String,
    @SerializedName("date_utc")
    val dateUTC: String,
    @SerializedName("date_unix")
    val dateUnix: Double,
    @SerializedName("date_local")
    val dateLocal: String,
    val upcoming: Boolean,
    @SerializedName("id")
    val ID: String
)
