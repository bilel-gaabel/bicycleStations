package com.billgaag.jcdecaux.bicyclestations.ui.main

import com.billgaag.jcdecaux.bicyclestations.models.Station
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by bill_gaag on 31/08/2018.
 */
class MainActivityPresenter : MainActivityContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainActivityContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainActivityContract.View) {
        this.view = view
        view.showListStationsFragment() // as default
    }

    override fun goToInforamtionFragment(station: Station) {
        view.showInfoStationFragment(station)
    }
}