package com.letssee.covid19.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Table {
    @SerializedName("TotalCases")
    @Expose
    var totalCases: String? = null

    @SerializedName("NewCases")
    @Expose
    var newCases: String? = null

    @SerializedName("TotalDeaths")
    @Expose
    var totalDeaths: String? = null

    @SerializedName("NewDeaths")
    @Expose
    var newDeaths: String? = null

    @SerializedName("TotalRecovered")
    @Expose
    var totalRecovered: String? = null

    @SerializedName("ActiveCases")
    @Expose
    var activeCases: String? = null

    @SerializedName("TotalTests")
    @Expose
    var totalTests: String? = null

    @SerializedName("Continent")
    @Expose
    var continent: String? = null

    @SerializedName("Deaths_1M_pop")
    @Expose
    var deaths1MPop: String? = null

    @SerializedName("Country")
    @Expose
    var country: String? = null

    @SerializedName("Serious_Critical")
    @Expose
    var seriousCritical: String? = null

    @SerializedName("Tests_1M_Pop")
    @Expose
    var tests1MPop: String? = null

    @SerializedName("TotCases_1M_Pop")
    @Expose
    var totCases1MPop: String? = null

}