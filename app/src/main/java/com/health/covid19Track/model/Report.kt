package com.health.covid19Track.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.letssee.covid19.model.Table

class Report {
    @SerializedName("cases")
    @Expose
    var cases: Int? = null

    @SerializedName("recovered")
    @Expose
    var recovered: Int? = null

    @SerializedName("table")
    @Expose
    var table: List<List<Table>>? =
        null

}