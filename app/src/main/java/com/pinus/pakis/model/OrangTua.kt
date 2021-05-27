package com.pinus.pakis.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OrangTua(
    var id: String?,
    var nama: String,
    var email: String,
    var password: String
): Parcelable {
    constructor(): this("", "", "", "")
}
