package com.example.thirtydaystips.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


/*
 * Data class used to encapsulate individual tip data.
 */
data class Tip(
    @StringRes val dayRes: Int,
    @StringRes val titleRes : Int,
    @DrawableRes val imageRes: Int,
    @StringRes val descRes: Int
)
