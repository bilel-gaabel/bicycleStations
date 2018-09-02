package com.billgaag.jcdecaux.bicyclestations.di.module

import android.app.Application
import com.billgaag.jcdecaux.bicyclestations.BaseApp

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by bill_gaag on 31/08/2018.
 */
@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return baseApp
    }
}