package com.health.covid19Track.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Country {
    var reports: List<ReportC>? = null

}
class ReportC {
    @SerializedName("Active Cases_text")
    @Expose
    var activeCasesText: String? = null

    @SerializedName("Country_text")
    @Expose
    var countryText: String? = null

    @SerializedName("Last Update")
    @Expose
    var lastUpdate: String? = null

    @SerializedName("New Cases_text")
    @Expose
    var newCasesText: String? = null

    @SerializedName("New Deaths_text")
    @Expose
    var newDeathsText: String? = null

    @SerializedName("Total Cases_text")
    @Expose
    var totalCasesText: String? = null

    @SerializedName("Total Deaths_text")
    @Expose
    var totalDeathsText: String? = null

    @SerializedName("Total Recovered_text")
    @Expose
    var totalRecoveredText: String? = null
}