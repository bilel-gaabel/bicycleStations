package com.billgaag.jcdecaux.bicyclestations.di.component

import com.billgaag.jcdecaux.bicyclestations.di.module.ActivityModule
import com.billgaag.jcdecaux.bicyclestations.ui.main.MainActivity
import dagger.Component

/**
 * Created by bill_gaag on 31/08/2018.
 */
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainStationsActivity: MainActivity)

}