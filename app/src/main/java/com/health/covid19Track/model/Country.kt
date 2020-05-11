package com.health.covid19Track.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Country {
    @SerializedName("reports")
    @Expose
    var reports: List<Report>? = null

}