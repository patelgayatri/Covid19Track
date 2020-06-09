package com.health.covid19Track.network

import com.health.covid19Track.model.Country
import com.health.covid19Track.model.HomeData
import com.health.covid19Track.model.HomeResult
import io.reactivex.Observable
import retrofit2.http.GET

interface RequestInterface {
    //https://covid19-server.chrismichael.now.sh/api/v1
    //https://covid19-server.chrismichael.now.sh/api/v1/AllReports
    //https://corona-virus-stats.herokuapp.com/api/v1/cases/general-stats
    //https://covid-19.dataflowkit.com/v1/australia


    @GET("api/v1/AllReports")
    fun getCountryStats(): Observable<Country>

    @GET("api/v1/cases/general-stats")
    fun getGeneralStats(): Observable<HomeResult>

}
