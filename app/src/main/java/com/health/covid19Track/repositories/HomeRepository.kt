package com.health.covid19Track.repositories

import androidx.lifecycle.MutableLiveData
import com.health.covid19Track.model.HomeResult
import com.health.covid19Track.network.RequestInterface
import com.health.covid19Track.network.RetrofitService.RetrofitBuilder
import com.health.covid19Track.network.RetrofitService.cteateService
import com.health.covid19Track.utils.BASE_URL
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeRepository {
    var liveData = MutableLiveData<HomeResult>()
    private val requestAPI: RequestInterface
    val data: MutableLiveData<HomeResult>
        get() {
            val homeResultObservable = requestAPI.getGeneralStats()
            homeResultObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : Observer<HomeResult> {
                    override fun onSubscribe(d: Disposable) {}
                    override fun onNext(homeResult: HomeResult) {
                        liveData.value = homeResult
                    }

                    override fun onError(e: Throwable) {}
                    override fun onComplete() {}
                })
            return liveData
        }

    companion object {
        var homeRepository: HomeRepository? = null
        val instance: HomeRepository?
            get() {
                if (homeRepository == null) {
                    homeRepository = HomeRepository()
                }
                return homeRepository
            }
    }

    init {
        RetrofitBuilder(BASE_URL)
        requestAPI = cteateService(RequestInterface::class.java)
    }
}