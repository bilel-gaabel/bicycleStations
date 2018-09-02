package com.billgaag.jcdecaux.bicyclestations.di.component

import com.billgaag.jcdecaux.bicyclestations.di.module.FragmentModule
import com.billgaag.jcdecaux.bicyclestations.ui.infostation.InfoStationFragment
import com.billgaag.jcdecaux.bicyclestations.ui.liststations.ListStationsFragment
import dagger.Component

/**
 * Created by bill_gaag on 31/08/2018.
 */
@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(infoStationFragment: InfoStationFragment)

    fun inject(listStationsFragment: ListStationsFragment)

}