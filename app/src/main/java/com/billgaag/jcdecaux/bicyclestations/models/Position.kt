package com.billgaag.jcdecaux.bicyclestations.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Position (var lat:Float,var lng:Float): Parcelable