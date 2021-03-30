package com.project.lab1.network.models

import com.google.gson.annotations.SerializedName


class Image (
    val id: String,
    val created_at: String,
    val width: Int,
    val height: Int,
    val color: String,
    val alt_description: String?,
    val links: Links,
    val categories: ArrayList<String>,
    val likes: Int,
    val urls: URLS
)

//{
//    "id": "6Xi1kR0EQVU",
//    "created_at": "2021-03-29T23:09:35-04:00",
//    "width": 3712,
//    "height": 5568,
//    "color": "#0c2640",
//    "alt_description": "blue jellyfish in water during daytime",
//    "urls": {
//    "raw": "https://images.unsplash.com/photo-1617073397915-c934cf34a76c?ixid=MnwyMTkxMDF8MHwxfGFsbHwyfHx8fHx8Mnx8MTYxNzEwMzE1MQ&ixlib=rb-1.2.1",
//    "full": "https://images.unsplash.com/photo-1617073397915-c934cf34a76c?crop=entropy&cs=srgb&fm=jpg&ixid=MnwyMTkxMDF8MHwxfGFsbHwyfHx8fHx8Mnx8MTYxNzEwMzE1MQ&ixlib=rb-1.2.1&q=85",
//    "regular": "https://images.unsplash.com/photo-1617073397915-c934cf34a76c?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMTkxMDF8MHwxfGFsbHwyfHx8fHx8Mnx8MTYxNzEwMzE1MQ&ixlib=rb-1.2.1&q=80&w=1080",
//    "small": "https://images.unsplash.com/photo-1617073397915-c934cf34a76c?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMTkxMDF8MHwxfGFsbHwyfHx8fHx8Mnx8MTYxNzEwMzE1MQ&ixlib=rb-1.2.1&q=80&w=400",
//    "thumb": "https://images.unsplash.com/photo-1617073397915-c934cf34a76c?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMTkxMDF8MHwxfGFsbHwyfHx8fHx8Mnx8MTYxNzEwMzE1MQ&ixlib=rb-1.2.1&q=80&w=200"
//},
//    "links": {
//    "self": "https://api.unsplash.com/photos/6Xi1kR0EQVU",
//    "html": "https://unsplash.com/photos/6Xi1kR0EQVU",
//    "download": "https://unsplash.com/photos/6Xi1kR0EQVU/download",
//    "download_location": "https://api.unsplash.com/photos/6Xi1kR0EQVU/download?ixid=MnwyMTkxMDF8MHwxfGFsbHwyfHx8fHx8Mnx8MTYxNzEwMzE1MQ"
//},



//},


//class Launch(
//    val links: Links,
//    @SerializedName("static_fire_date_utc")
//    val staticFireDateUTC: String?,
//    @SerializedName("static_fire_date_unix")
//    val staticFireDateUnix: Double?,
//    @SerializedName("rocket")
//    val rocketID: String,
//    val success: Boolean,
//    val details: String?,
//    val ships: ArrayList<String>,
//    @SerializedName("launchpad")
//    val launchpadID: String,
//    @SerializedName("flight_number")
//    val flightNumber: Int,
//    @SerializedName("name")
//    val missionName: String,
//    @SerializedName("date_utc")
//    val dateUTC: String,
//    @SerializedName("date_unix")
//    val dateUnix: Double,
//    @SerializedName("date_local")
//    val dateLocal: String,
//    val upcoming: Boolean,
//    @SerializedName("id")
//    val ID: String
//)