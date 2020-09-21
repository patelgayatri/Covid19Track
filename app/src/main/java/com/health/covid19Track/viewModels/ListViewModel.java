package com.health.covid19Track.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.health.covid19Track.model.Country;
import com.health.covid19Track.model.Report;
import com.health.covid19Track.model.ReportC;
import com.health.covid19Track.repositories.CasesRepository;

import java.util.List;

public class ListViewModel extends ViewModel {

    private MutableLiveData<List<ReportC>> countryMutableLiveData;
    private CasesRepository casesRepository;

    public ListViewModel() {
        if (countryMutableLiveData != null) {
            return;
        }
        casesRepository = CasesRepository.getInstance();
        countryMutableLiveData = casesRepository.getCases();

    }

    public MutableLiveData<List<ReportC>> getCases() {
        return countryMutableLiveData;
    }
}