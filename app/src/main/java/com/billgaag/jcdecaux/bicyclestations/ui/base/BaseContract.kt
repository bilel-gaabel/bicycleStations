package com.billgaag.jcdecaux.bicyclestations.ui.base

/**
 * Created by bill_gaag on 31/08/2018.
 */
class BaseContract {
    interface Presenter<in T> {
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View
}