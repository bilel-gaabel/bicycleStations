package com.billgaag.jcdecaux.bicyclestations.di.module

import com.billgaag.jcdecaux.bicyclestations.api.ApiServiceInterface
import com.billgaag.jcdecaux.bicyclestations.ui.infostation.InfoStationContract
import com.billgaag.jcdecaux.bicyclestations.ui.infostation.InfoStationFragment
import com.billgaag.jcdecaux.bicyclestations.ui.infostation.InfoStationPresenter
import com.billgaag.jcdecaux.bicyclestations.ui.liststations.ListStationsContract
import com.billgaag.jcdecaux.bicyclestations.ui.liststations.ListStationsFragment
import com.billgaag.jcdecaux.bicyclestations.ui.liststations.ListStationsPresenter


import dagger.Module
import dagger.Provides

/**
 * Created by bill_gaag on 31/08/2018.
 */
@Module
class FragmentModule {

    @Provides
    fun provideInfoPresenter(): InfoStationContract.Presenter {
        return InfoStationPresenter()
    }

    @Provides
    fun provideListPresenter(): ListStationsContract.Presenter {
        return ListStationsPresenter()
    }

    @Provides
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }
}