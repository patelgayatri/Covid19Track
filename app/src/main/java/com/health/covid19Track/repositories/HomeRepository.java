package com.health.covid19Track.repositories;

import androidx.lifecycle.MutableLiveData;

import com.health.covid19Track.model.Country;
import com.health.covid19Track.model.HomeResult;
import com.health.covid19Track.network.RequestInterface;
import com.health.covid19Track.network.RetrofitService;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.health.covid19Track.utils.ConstantsKt.BASE_URL;

public class HomeRepository {

    static HomeRepository homeRepository;
    private ArrayList<String> data = new ArrayList<>();
    MutableLiveData<HomeResult> liveData = new MutableLiveData<>();

    public static HomeRepository getInstance() {
        if (homeRepository == null) {
            homeRepository = new HomeRepository();
        }
        return homeRepository;
    }

    private RequestInterface requestAPI;

    public HomeRepository() {
        RetrofitService.RetrofitBuilder(BASE_URL);
        requestAPI = RetrofitService.cteateService(RequestInterface.class);
    }

    public MutableLiveData<HomeResult> getData() {
        Observable<HomeResult> homeResultObservable = requestAPI.getGeneralStats();
        homeResultObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<HomeResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeResult homeResult) {

                        liveData.setValue(homeResult);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return liveData;
    }

}
