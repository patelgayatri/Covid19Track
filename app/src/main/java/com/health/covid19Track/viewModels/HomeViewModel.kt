package com.health.covid19Track.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.health.covid19Track.model.HomeResult
import com.health.covid19Track.repositories.HomeRepository

class HomeViewModel : ViewModel() {
    private var mutableLiveData: MutableLiveData<HomeResult>?
    var homeRepository: HomeRepository

    val data: LiveData<HomeResult>?
        get() = mutableLiveData

    init {
        homeRepository = HomeRepository.instance!!
        mutableLiveData = homeRepository.data
    }
}