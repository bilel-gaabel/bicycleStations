package com.billgaag.jcdecaux.bicyclestations.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by bill_gaag on 31/08/2018.
 */
@Parcelize
data class Station(var number: Int, var name: String, var address: String, var position: Position, var banking: Boolean, var bonus: Boolean, var status: String, var contract_name: String, var bike_stands: Int, var available_bike_stands: Int, var available_bikes: Int, var last_update: Long) : Parcelable