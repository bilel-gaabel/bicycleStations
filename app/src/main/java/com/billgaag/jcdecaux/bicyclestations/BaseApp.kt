package com.billgaag.jcdecaux.bicyclestations

import android.app.Application
import com.billgaag.jcdecaux.bicyclestations.di.component.ApplicationComponent
import com.billgaag.jcdecaux.bicyclestations.di.component.DaggerApplicationComponent
import com.billgaag.jcdecaux.bicyclestations.di.module.ApplicationModule

/**
 * Created by bill_gaag on 31/08/2018.
 */
class BaseApp : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()


    }

    fun setup() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}