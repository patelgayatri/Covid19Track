package com.health.covid19Track.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.health.covid19Track.model.HomeResult;
import com.health.covid19Track.repositories.HomeRepository;

public class HomeViewModel extends ViewModel {


    private MutableLiveData<HomeResult> mutableLiveData;
    HomeRepository homeRepository;

    public HomeViewModel() {
        if (mutableLiveData != null) {
            return;
        }
        homeRepository = HomeRepository.getInstance();
        mutableLiveData = homeRepository.getData();
    }

    public LiveData<HomeResult> getData() {
        return mutableLiveData;
    }
}