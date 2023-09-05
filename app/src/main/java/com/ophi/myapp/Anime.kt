package com.ophi.myapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val name: String,
    val synopsis: String,
    val genre: String,
    val release: String,
    val photo: Int
) : Parcelable
