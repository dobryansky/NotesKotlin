package com.artem.noteskotlin.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Note(
    val id: Int,
    val name: String,
    val date : String,
    val description : String,
    val done_state: Boolean

): Parcelable
