package com.billgaag.jcdecaux.bicyclestations.di.module

import android.app.Activity
import com.billgaag.jcdecaux.bicyclestations.ui.main.MainActivity
import com.billgaag.jcdecaux.bicyclestations.ui.main.MainActivityContract
import com.billgaag.jcdecaux.bicyclestations.ui.main.MainActivityPresenter

import dagger.Module
import dagger.Provides

/**
 * Created by bill_gaag on 31/08/2018.
 */
@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainActivityContract.Presenter {
        return MainActivityPresenter()
    }

}