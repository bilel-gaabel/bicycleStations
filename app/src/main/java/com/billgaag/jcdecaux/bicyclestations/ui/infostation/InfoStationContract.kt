package com.billgaag.jcdecaux.bicyclestations.ui.infostation

import com.billgaag.jcdecaux.bicyclestations.models.Station
import com.billgaag.jcdecaux.bicyclestations.ui.base.BaseContract

/**
 * Created by bill_gaag on 31/08/2018.
 */
class InfoStationContract {

    interface View: BaseContract.View {
        fun showProgress(show: Boolean)
    }

    interface Presenter: BaseContract.Presenter<View>
}