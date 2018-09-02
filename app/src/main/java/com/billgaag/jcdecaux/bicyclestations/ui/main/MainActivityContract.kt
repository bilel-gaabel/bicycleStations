package com.billgaag.jcdecaux.bicyclestations.ui.main

import com.billgaag.jcdecaux.bicyclestations.models.Station
import com.billgaag.jcdecaux.bicyclestations.ui.base.BaseContract

/**
 * Created by bill_gaag on 31/08/2018.
 */
class MainActivityContract {

    interface View: BaseContract.View {
        fun showInfoStationFragment(station: Station)
        fun showListStationsFragment()
    }

    interface Presenter: BaseContract.Presenter<MainActivityContract.View> {
        fun goToInforamtionFragment(station: Station)
    }
}