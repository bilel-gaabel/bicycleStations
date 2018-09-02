package com.billgaag.jcdecaux.bicyclestations.ui.infostation

import com.billgaag.jcdecaux.bicyclestations.models.Station
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by bill_gaag on 31/08/2018.
 */
class InfoStationPresenter : InfoStationContract.Presenter {

    //private val subscriptions = CompositeDisposable()
    private lateinit var view: InfoStationContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }

    override fun attach(view: InfoStationContract.View) {
        this.view = view
    }

}