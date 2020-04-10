package com.example.studentportal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Portal(
    val name: String,
    val url:  String
) : Parcelable {
    companion object {
        val PORTAL_NAMES = arrayOf(
            "US",
            "HvA",
            "Students Come & Go",
            "Roosters"
        )
        val PORTAL_URLS = arrayOf(
            "https://ev.us.es",
            "https://hva.nl",
            "https://hbo-ict.studentscomeandgo.nl",
            "https://rooster.hva.nl"
            )
    }
}