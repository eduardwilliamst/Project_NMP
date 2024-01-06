package com.example.project_nmp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Genre (
    val id: Int,
    val name: String,
): Parcelable {
    override fun toString(): String {
        return name
    }
}
