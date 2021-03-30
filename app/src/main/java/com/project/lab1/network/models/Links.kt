package com.project.lab1.network.models

import com.google.gson.annotations.SerializedName
import java.net.URL

class Links(
    val self: String,
    val html: String,
    val download: String,
    val download_location: String
)

//    "links": {
//    "self": "https://api.unsplash.com/photos/6Xi1kR0EQVU",
//    "html": "https://unsplash.com/photos/6Xi1kR0EQVU",
//    "download": "https://unsplash.com/photos/6Xi1kR0EQVU/download",
//    "download_location": "https://api.unsplash.com/photos/6Xi1kR0EQVU/download?ixid=MnwyMTkxMDF8MHwxfGFsbHwyfHx8fHx8Mnx8MTYxNzEwMzE1MQ"
//},

//class Links(
//    val patch: Patch,
//    val flickr: Flickr,
//    val webcast: URL,
//    @SerializedName("youtube_id")
//    val youtubeID: String,
//    val article: URL?,
//    val wikipedia: URL?
//) {
//    data class Patch(
//        val small: URL?,
//        val large: URL?
//    )
//
//    data class Flickr (
//        val original: ArrayList<URL>
//    )
//}