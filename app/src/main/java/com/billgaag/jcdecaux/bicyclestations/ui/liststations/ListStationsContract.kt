package com.billgaag.jcdecaux.bicyclestations.ui.liststations

import com.billgaag.jcdecaux.bicyclestations.models.Station
import com.billgaag.jcdecaux.bicyclestations.ui.base.BaseContract

/**
 * Created by bill_gaag on 31/08/2018.
 */
class ListStationsContract {
    interface View : BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: List<Station>)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadData()
    }
}