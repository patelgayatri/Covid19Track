package com.health.covid19Track.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.health.covid19Track.model.Country;
import com.health.covid19Track.repositories.CasesRepository;

public class ListViewModel extends ViewModel {

    private MutableLiveData<Country> countryMutableLiveData;
    private CasesRepository casesRepository;

    public ListViewModel() {
        if (countryMutableLiveData != null) {
            return;
        }
        casesRepository = CasesRepository.getInstance();
        countryMutableLiveData = casesRepository.getCases();

    }

    public LiveData<Country> getCases() {
        return countryMutableLiveData;
    }
}