package com.billgaag.jcdecaux.bicyclestations.di.component

import com.billgaag.jcdecaux.bicyclestations.BaseApp
import com.billgaag.jcdecaux.bicyclestations.di.module.ApplicationModule
import dagger.Component

/**
 * Created by bill_gaag on 31/08/2018.
 */
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

}