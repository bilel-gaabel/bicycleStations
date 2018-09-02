package com.billgaag.jcdecaux.bicyclestations.ui.liststations

import com.billgaag.jcdecaux.bicyclestations.api.ApiServiceInterface
import com.billgaag.jcdecaux.bicyclestations.models.Station
import com.billgaag.jcdecaux.bicyclestations.util.Constants
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by bill_gaag on 31/08/2018.
 */
class ListStationsPresenter : ListStationsContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()
    private lateinit var view: ListStationsContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: ListStationsContract.View) {
        this.view = view
    }

    override fun loadData() {
        var subscribe = api.getStationList(Constants.MY_KEY).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ list: List<Station>? ->
                    view.showProgress(false)
                    view.loadDataSuccess(list!!)
                }, { error ->
                    view.showProgress(false)
                    view.showErrorMessage(error.localizedMessage)
                })

        subscriptions.add(subscribe)
    }

}